package it.com.ibm.generali.capitalreporting.controller.web;

import it.com.ibm.generali.capitalreporting.dao.ScopeDao;
import it.com.ibm.generali.capitalreporting.model.Report;
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
import java.util.List;
import java.util.Set;

@Controller
public class ReportsController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ReportsController.class);

    private ScopeDao scopes;
    private ScopeService scopeService;

    @Autowired
    public ReportsController(ScopeDao scopeDao,
                             ScopeService scopeService)
    {
        this.scopes = scopeDao;
        this.scopeService = scopeService;
    }

    /**
     * FreeReporting GET
     */
    @RequestMapping("/freereporting")
    public String freeReporting(Model model, HttpSession session)
    {
        logger.info("/freereporting page");
        return this.pageSetup("freereporting", model, session);
    }

    /**
     * Browse GET
     */
    @RequestMapping("/browse")
    public String browse(Model model, HttpSession session)
    {
        logger.info("/browse = Scope Level 0");
        List<Scope> scopesZero = this.scopes.findByParentAndPublishedIsTrue(-1);
        model.addAttribute("mode", "Analysis");
        model.addAttribute("scopes", scopesZero);
        return this.pageSetup("browse", model, session);
    }

    /**
     * Browse GET + mode
     */
    @RequestMapping(value = "/browse", method = RequestMethod.GET, params = {"mode"})
    public String browseMode(Model model, @RequestParam("mode") String mode, HttpSession session)
    {
        logger.info("/browse = Scope Level 0 with mode = " + mode);
        List<Scope> scopesZero = this.scopes.findByParentAndPublishedIsTrue(-1);
        model.addAttribute("mode", mode);
        model.addAttribute("scopes", scopesZero);
        return this.pageSetup("browse", model, session);
    }

    /**
     * Scopes GET
     * Get a list of scopes that are children of the scope with Scope_id = parent
     * If the list of children is empty, then a list of reports is shown
     */
    @RequestMapping(value = "/scopes", method = RequestMethod.GET, params = {"parent", "mode"})
    public String scopes(Model model,
                         @RequestParam("parent") Long parentId,
                         @RequestParam("mode") String mode,
                         HttpSession session)
    {
        logger.info("/scopes for parent = " + parentId);
        List<Scope> scopes = this.scopes.findByParentAndPublishedIsTrue(parentId);
        Scope parent = this.scopes.findOne(parentId);
        List<Scope> parents = this.scopeService.getParents(parent);

        if (scopes.size() == 0 && parent.getReports().size() > 0)
        {
            return "redirect:/reports?scope=" + parentId + "&mode=" + mode;
        }

        model.addAttribute("mode", mode);
        model.addAttribute("parents", parents);
        model.addAttribute("scopes", scopes);
        return this.pageSetup("scopes", model, session);
    }

    /**
     * Reports GET
     */
    @RequestMapping(value = "/reports", method = RequestMethod.GET, params = {"scope", "mode"})
    public String reports(Model model,
                          @RequestParam("scope") Long scopeId,
                          @RequestParam("mode") String mode,
                          HttpSession session)
    {
        logger.info("/Report page for scope ID = " + scopeId + " in mode = " + mode);
        Scope scope = this.scopes.findOne(scopeId);
        List<Scope> parents = this.scopeService.getParents(scope);
        Set<Report> reports = scope.getReports();

        model.addAttribute("mode", mode);
        model.addAttribute("parents", parents);
        model.addAttribute("reports", reports);

        return this.pageSetup("archive", model, session);
    }


}
