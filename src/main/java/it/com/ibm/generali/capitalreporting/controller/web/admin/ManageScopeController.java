package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.ScopeDao;
import it.com.ibm.generali.capitalreporting.dao.TagDao;
import it.com.ibm.generali.capitalreporting.model.Scope;
import it.com.ibm.generali.capitalreporting.service.ScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class ManageScopeController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ManageScopeController.class);

    private ScopeDao scopes;
    private TagDao tags;
    private ScopeService scopeService;

    @Autowired
    public ManageScopeController(ScopeDao scopeDao,
                                 TagDao tagDao,
                                 ScopeService scopeService)
    {
        this.scopes = scopeDao;
        this.tags = tagDao;
        this.scopeService = scopeService;
    }

    /**
     * Manage scopes initial page GET
     */
    @RequestMapping("/managescopes")
    public String manageScopes(Model model, HttpSession session)
    {
        logger.info("/managescopes");
        List<Scope> scopesZero = this.scopes.findByParent(-1);
        model.addAttribute("selscope", scopesZero.get(0));
        model.addAttribute("scopes", scopesZero);
        model.addAttribute("children", true);
        return this.configureTemplate(model, session);
    }

    /**
     * Manage scope GET with scope id
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.GET, params = {"scope"})
    public String manageScope(Model model, @RequestParam("scope") long scopeId, HttpSession session)
    {
        logger.info("/managescopes GET with scope=" + scopeId);
        Scope scopeObj = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getScopeParents(scopeObj);
        List<Scope> siblings = this.scopeService.getSiblings(scopeObj);
        boolean hasChildren = this.scopeService.hasChildren(scopeObj);
        model.addAttribute("selscope", scopeObj);
        model.addAttribute("parents", parents);
        model.addAttribute("scopes", siblings);
        model.addAttribute("children", hasChildren);
        if (scopeObj.getLevel() > 0)
        {
            model.addAttribute("tags", this.tags.findAll());
        }
        return this.configureTemplate(model, session);
    }

    /**
     * Manage scope POST
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.POST)
    public String editScope(Model model,
                            @RequestParam("id") long id,
                            @RequestParam("name") String name,
                            @RequestParam(value = "published", defaultValue = "false") boolean published,
                            @RequestParam(value = "tags", required = false) String[] tags)
    {
        logger.info("/managescopes POST with scope=" + id);
        logger.info("/managescopes POST with name=" + name);
        logger.info("/managescopes POST with published=" + published);
        Scope scopeObj = this.scopes.findOne(id);
        scopeObj.setName(name);
        scopeObj.setPublished(published);
        if (tags != null)
        {
            scopeObj.setAllTags(Arrays.asList(tags));
        }
        this.scopes.save(scopeObj);
        return "redirect:/managescope?scope=" + id;
    }

    /**
     * Manage child of scope GET with scope id
     */
    @RequestMapping(value = "/managechild", method = RequestMethod.GET, params = {"scope"})
    public String manageChild(Model model, @RequestParam("scope") long scopeId, HttpSession session)
    {
        logger.info("/managechild GET with scope=" + scopeId);
        Scope scopeObj = this.scopes.findOne(scopeId);
        List<Scope> children = this.scopeService.getChildren(scopeObj);
        if (children == null)
        {
            return "redirect:/managescope?scope=" + scopeId;
        }
        Scope selScope = children.get(0);
        return "redirect:/managescope?scope=" + selScope.getId();
    }

    private String configureTemplate(Model model, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "mngscopes";
    }

}
