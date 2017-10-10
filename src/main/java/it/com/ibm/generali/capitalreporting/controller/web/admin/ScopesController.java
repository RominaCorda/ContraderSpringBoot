package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.ScopeDao;
import it.com.ibm.generali.capitalreporting.dao.TagDao;
import it.com.ibm.generali.capitalreporting.framework.Utilities;
import it.com.ibm.generali.capitalreporting.model.Scope;
import it.com.ibm.generali.capitalreporting.model.ScopeType;
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
public class ScopesController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ScopesController.class);

    private ScopeDao scopes;
    private TagDao tags;
    private ScopeService scopeService;

    @Autowired
    public ScopesController(ScopeDao scopeDao,
                            TagDao tagDao,
                            ScopeService scopeService)
    {
        this.scopes = scopeDao;
        this.tags = tagDao;
        this.scopeService = scopeService;
    }

    /**
     * Manage scopes initial page GET with MODE
     */
    @RequestMapping(value = "/managescopes", method = RequestMethod.GET, params = {"mode"})
    public String manageScopesWithMode(Model model,
                                       HttpSession session,
                                       @RequestParam("mode") String mode)
    {
        logger.info("/managescopes MODE=" + mode);
        ScopeType type = Utilities.INSTANCE.getScopeType(mode);
        List<Scope> scopesZero = this.scopes.findByTypeAndParent(type, -1L);
        model.addAttribute("mode", mode);
        model.addAttribute("selscope", scopesZero.get(0));
        model.addAttribute("scopes", scopesZero);
        model.addAttribute("children", true);
        return this.configureTemplate(model, session);
    }

    /**
     * Roles with delete
     */
    @RequestMapping(value = "/deletescope", method = RequestMethod.GET, params = {"id"})
    public String deleteScope(Model model, HttpSession session, @RequestParam("id") String scopeId)
    {
        String redirect = "redirect:/managescopes";
        try
        {
            long scopeKey = Long.parseLong(scopeId);
            Scope scope = this.scopes.findOne(scopeKey);
            Scope firstSibling = this.scopeService.getSiblings(scope).getFirst();
            this.scopes.delete(scopeKey);
            redirect = "redirect:/managescope?scope=" + firstSibling.getId();

        }
        catch (Exception exc)
        {
            logger.error(exc.getMessage());
        }

        return redirect;
    }

    /**
     * Manage scope GET with scope id
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.GET, params = {"scope"})
    public String manageScope(Model model, @RequestParam("scope") long scopeId, HttpSession session)
    {
        logger.info("/managescopes GET with scope=" + scopeId);
        Scope scopeObj = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getParents(scopeObj);
        List<Scope> siblings = this.scopeService.getSiblings(scopeObj);
        model.addAttribute("mode", scopeObj.getType().toString().toLowerCase());
        model.addAttribute("canAddReports", this.scopeService.canAddReports(scopeObj));
        model.addAttribute("selscope", scopeObj);
        model.addAttribute("parents", parents);
        model.addAttribute("scopes", siblings);
        if (this.scopeService.getLevel(scopeObj) > 0)
        {
            model.addAttribute("tags", this.tags.findAll());
        }
        return this.configureTemplate(model, session);
    }


    /**
     * Manage scope GET - special case for new scopes
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.GET, params = {"parent"})
    public String manageScopeNew(Model model, @RequestParam("parent") long scopeId, HttpSession session)
    {
        logger.info("/managescopes GET for new scopes with parent = " + scopeId);
        Scope parent = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getParents(parent);
        parents.add(parent);
        model.addAttribute("mode", parent.getType().toString().toLowerCase());
        model.addAttribute("parents", parents);
        model.addAttribute("tags", this.tags.findAll());
        return this.configureTemplate(model, session);
    }

    /**
     * Manage scope POST
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.POST)
    public String editScope(Model model,
                            @RequestParam("mode") String mode,
                            @RequestParam("id") long id,
                            @RequestParam("parent") long parent,
                            @RequestParam("name") String name,
                            @RequestParam(value = "published", defaultValue = "false") boolean published,
                            @RequestParam(value = "tags", required = false) String[] tags)
    {
        logger.info("/managescope POST with scope=" + id);
        Scope scopeObj;
        if (id > 0)
        {
            scopeObj = this.scopes.findOne(id);
        }
        else
        {
            ScopeType type = Utilities.INSTANCE.getScopeType(mode);
            scopeObj = new Scope();
            scopeObj.setParent(parent);
            scopeObj.setType(type);
        }
        scopeObj.setName(name);
        scopeObj.setPublished(published);
        if (tags != null)
        {
            scopeObj.setAllTags(Arrays.asList(tags));
        }
        final Scope savedScope = this.scopes.save(scopeObj);
        return "redirect:/managescope?scope=" + savedScope.getId();
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
        if (children == null || children.size() == 0)
        {
            return "redirect:/managescope?parent=" + scopeId;
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
