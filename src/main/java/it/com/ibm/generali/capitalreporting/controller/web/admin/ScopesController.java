package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.ScopeDao;
import it.com.ibm.generali.capitalreporting.dao.TagDao;
import it.com.ibm.generali.capitalreporting.dao.TemplateDao;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.framework.Utilities;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import it.com.ibm.generali.capitalreporting.model.Scope;
import it.com.ibm.generali.capitalreporting.model.ScopeType;
import it.com.ibm.generali.capitalreporting.model.Template;
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
import java.util.*;

@Controller
public class ScopesController extends SessionHelper {
    private Logger logger = LoggerFactory.getLogger(ScopesController.class);

    private ScopeDao scopes;
    private TagDao tags;
    private UserDao users;
    private TemplateDao templates;
    private ScopeService scopeService;

    @Autowired
    public ScopesController(ScopeDao scopeDao,
                            TagDao tagDao,
                            UserDao userDao,
                            TemplateDao templateDao,
                            ScopeService scopeService) {
        this.scopes = scopeDao;
        this.tags = tagDao;
        this.users = userDao;
        this.templates = templateDao;
        this.scopeService = scopeService;
    }

    /**
     * Manage scopes initial page GET with MODE
     */
    @RequestMapping(value = "/managescopes", method = RequestMethod.GET, params = {"mode"})
    public String manageScopesWithMode(Model model,
                                       HttpSession session,
                                       @RequestParam("mode") String mode) {
        logger.info("/managescopes MODE=" + mode);
        ScopeType type = Utilities.INSTANCE.getScopeType(mode);
        List<Scope> scopesZero = this.scopes.findByTypeAndParent(type, -1L);
        model.addAttribute("mode", mode);
        model.addAttribute("users", this.users.findAll());
        model.addAttribute("templates", this.templates.findAll());
        model.addAttribute("selscope", scopesZero.size() > 0 ? scopesZero.get(0) : null);
        model.addAttribute("scopes", scopesZero);
        model.addAttribute("children", true);
        return this.configureTemplate(model, session);
    }

    /**
     * Roles with delete
     */
    @RequestMapping(value = "/deletescope", method = RequestMethod.GET, params = {"id"})
    public String deleteScope(Model model, HttpSession session, @RequestParam("id") String scopeId) {
        String redirect = "redirect:/managescopes";
        try {
            long scopeKey = Long.parseLong(scopeId);
            Scope scope = this.scopes.findOne(scopeKey);
            ScopeType mode = scope.getType();
            this.scopes.delete(scopeKey);
            List<Scope> siblings = this.scopeService.getSiblings(scope);
            if (siblings.size() > 0) {
                redirect = "redirect:/managescope?scope=" + siblings.get(0).getId();
            }
            else {
                redirect = "redirect:/managescopes?mode="+mode.toString().toLowerCase();
            }
        } catch (Exception exc) {
            logger.error(exc.getMessage());
        }

        return redirect;
    }

    /**
     * Roles with copy
     */
    @RequestMapping(value = "/copyscope", method = RequestMethod.GET, params = {"id"})
    public String copyScope(Model model, HttpSession session, @RequestParam("id") String scopeId) {
        String redirect = "redirect:/managescopes";
        try {
            Long scopeCopyId = scopeService.copyScope(Long.parseLong(scopeId));
            Scope scopeCopy = this.scopes.findOne(scopeCopyId);
            scopeCopy.name = scopeCopy.name + " nuovo";
            this.scopes.save(scopeCopy);
            redirect = "redirect:/managescope?scope=" + scopeCopyId;
        } catch (Exception exc) {
            logger.error(exc.getMessage());
        }

        return redirect;
    }

    /**
     * Manage scope GET with scope id
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.GET, params = {"scope"})
    public String manageScope(Model model, @RequestParam("scope") long scopeId, HttpSession session) {
        logger.info("/managescopes GET with scope=" + scopeId);
        Scope scopeObj = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getParents(scopeObj);
        List<Scope> siblings = this.scopeService.getSiblings(scopeObj);
        Set<CapitalUser> viewers = scopeObj.getUsers();
        List<CapitalUser> users = (List<CapitalUser>) this.users.findAll();
        List<Template> remainingTemplates = (List<Template>) this.templates.findAll();
        remainingTemplates.removeAll(scopeObj.getTemplates());
        users.removeAll(viewers);
        CapitalUser owner = scopeObj.getOwner();
        model.addAttribute("mode", scopeObj.getType().toString().toLowerCase());
        model.addAttribute("canAddReports", this.scopeService.canAddReports(scopeObj));
        model.addAttribute("users", users);
        model.addAttribute("viewers", viewers);
        model.addAttribute("owner", !owner.getUsername().equals("") ? owner : this.users.findOne("admin") );
        model.addAttribute("templates", scopeObj.getTemplates());
        model.addAttribute("remainingTemplates", remainingTemplates);
        model.addAttribute("selscope", scopeObj);
        model.addAttribute("parents", parents);
        model.addAttribute("scopes", siblings);
        if (this.scopeService.getLevel(scopeObj) > 0) {
            model.addAttribute("tags", this.tags.findAll());
        }
        return this.configureTemplate(model, session);
    }


    /**
     * Manage scope GET - special case for new scopes
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.GET, params = {"parent"})
    public String manageScopeNew(Model model, @RequestParam("parent") long scopeId, HttpSession session) {
        logger.info("/managescopes GET for new scopes with parent = " + scopeId);
        Scope parent = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getParents(parent);
//        parents.add(parent);
        model.addAttribute("mode", parent.getType().toString().toLowerCase());
        model.addAttribute("parents", parents);
        model.addAttribute("users", this.users.findAll());
        model.addAttribute("templates", this.templates.findAll());
        model.addAttribute("tags", this.tags.findAll());
        return this.configureTemplate(model, session);
    }

    /**
     * Manage scope POST
     * Add or edit scope
     */
    @RequestMapping(value = "/managescope", method = RequestMethod.POST)
    public String editScope(Model model,
                            @RequestParam("mode") String mode,
                            @RequestParam("id") long id,
                            @RequestParam("parent") long parent,
                            @RequestParam("name") String name,
                            @RequestParam(value = "published", defaultValue = "false") boolean published,
                            @RequestParam(value = "viewers", required = false) String[] viewers,
                            @RequestParam(value = "owner", defaultValue = "admin") String owner,
                            @RequestParam(value = "templates", required = false) String[] templateNames,
                            @RequestParam(value = "tags", required = false) String[] tags) {
        logger.info("/managescope POST with scope=" + id);
        Scope scopeObj;
        if (id > 0) {
            scopeObj = this.scopes.findOne(id);
        }
        else {
            ScopeType type = Utilities.INSTANCE.getScopeType(mode);
            scopeObj = new Scope();
            scopeObj.setParent(parent);
            scopeObj.setType(type);
        }
        CapitalUser userOwner = this.users.findOne(owner);
        CapitalUser admin = this.users.findOne("admin");
        if (owner != null) {
            scopeObj.setOwner(userOwner);
        }
        else {
            scopeObj.setOwner(admin);
        }
        Set<CapitalUser> newViewers = new HashSet<>();
        if (viewers != null) {
            for (String viewer : viewers)
                newViewers.add(this.users.findOne(viewer));
            scopeObj.setUsers(newViewers);
        }
        else {
            newViewers.add(admin);
            scopeObj.setUsers(newViewers);
        }
        if (templateNames != null) {
            Set<Template> newTemplates = new HashSet<>();
            for (String templateName : templateNames)
                newTemplates.add(this.templates.findByName(templateName));
            scopeObj.setTemplates(newTemplates);
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
    public String manageChild(Model model, @RequestParam("scope") long scopeId, HttpSession session) {
        logger.info("/managechild GET with scope=" + scopeId);
        Scope scopeObj = this.scopes.findOne(scopeId);
        List<Scope> children = this.scopeService.getChildren(scopeObj);
        if (children == null || children.size() == 0) {
            return "redirect:/managescope?parent=" + scopeId;
        }
        Scope selScope = children.get(0);
        return "redirect:/managescope?scope=" + selScope.getId();
    }

    private String configureTemplate(Model model, HttpSession session) {
        if (!this.isAdmin(session)) {
            return "redirect:login";
        }

        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "mngscopes";
    }

}
