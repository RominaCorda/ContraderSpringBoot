package it.com.ibm.generali.capitalreporting.controller.web;

import it.com.ibm.generali.capitalreporting.dao.ReportDao;
import it.com.ibm.generali.capitalreporting.dao.ScopeDao;
import it.com.ibm.generali.capitalreporting.dao.TagDao;
import it.com.ibm.generali.capitalreporting.dao.TemplateDao;
import it.com.ibm.generali.capitalreporting.model.Report;
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
import java.util.List;
import java.util.Random;

@Controller
public class ReportsController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ReportsController.class);

    private ScopeDao scopes;
    private ReportDao reports;
    private TemplateDao templates;
    private TagDao tags;
    private ScopeService scopeService;

    @Autowired
    public ReportsController(ScopeDao scopeDao,
                             ReportDao reportDao,
                             TemplateDao templateDao,
                             TagDao tagDao,
                             ScopeService scopeService)
    {
        this.scopes = scopeDao;
        this.reports = reportDao;
        this.templates = templateDao;
        this.tags = tagDao;
        this.scopeService = scopeService;
    }

    /**
     * the GET request for /report.
     */
    @RequestMapping("/report")
    public String reportDefault(Model model, HttpSession session)
    {
        logger.info("/report page for default report");
        model.addAttribute("report", this.reports.findOne(1L));
        return this.pageSetup("report", model, session);
    }

    /**
     * the GET request for /report.
     */
    @RequestMapping(value = "/report", method = RequestMethod.GET, params = {"id"})
    public String report(Model model,
                         @RequestParam("id") String reportId,
                         HttpSession session)
    {
        logger.info("/report page for report #" + reportId);
        model.addAttribute("report", this.reports.findOne(Long.valueOf(reportId)));
        return this.pageSetup("report", model, session);
    }

    /**
     * the GET request for /addnewreport.
     */
    @RequestMapping(value = "/addnewreport", method = RequestMethod.GET, params = {"scopeid"})
    public String addReport(Model model, @RequestParam("scopeid") String scopeId, HttpSession session)
    {
        logger.info("/addnewreport with scope ID = " + scopeId);
        Scope scope = this.scopes.findOne(Long.valueOf(scopeId));
        int simulationId = new Random().nextInt(99999) + 1;
        model.addAttribute("simulationid", String.valueOf(simulationId));
        model.addAttribute("scopeid", scopeId);
        model.addAttribute("tags", this.tags.findAll());
        model.addAttribute("templates", this.templates.findAll());
        model.addAttribute("scopedesc", this.scopeService.getParentsDescription(scope));
        return this.pageSetup("addnewreport", model, session);
    }

    /**
     * Add new report POST
     */
    @RequestMapping(value = "/addnewreport", method = RequestMethod.POST)
    public String addReport(@RequestParam("scopeid") String scopeId,
                            @RequestParam("template") String template,
                            @RequestParam("simulationid") int simulationId,
                            @RequestParam("reportingperiod") String reportingPeriod,
                            HttpSession session)
    {

        logger.info("Received POST for addnewreport with scope = " + scopeId);
        Report newReport = new Report();
        newReport.setUser(this.getCurrentUser(session));
        newReport.setTemplate(template);
        newReport.setSimulationId(simulationId);
        newReport.setReportingPeriod(reportingPeriod);
        Scope parent = this.scopes.findOne(Long.valueOf(scopeId));
        ScopeType mode = parent.getType();
        newReport.setScope(parent);
        this.reports.save(newReport);
        return "redirect:reports?scope=" + scopeId + "&mode=" + mode.toString().toLowerCase();

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
     * Browse GET: Browse scope from root level for mode (Official or Analysis)
     */
    @RequestMapping(value = "/browse", method = RequestMethod.GET, params = {"mode"})
    public String browseMode(Model model, @RequestParam("mode") String mode, HttpSession session)
    {
        logger.info("/browse = Scope Level 0 with mode = " + mode);
        ScopeType type = ScopeType.ANALYSIS;
        if (mode.toLowerCase().equals("official"))
        {
            type = ScopeType.OFFICIAL;
        }
        List<Scope> scopesZero = this.scopes.findByTypeAndParentAndPublishedIsTrue(type, -1);
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
        model.addAttribute("current", parent.getName());
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
        List<Report> reports = this.reports.findByScopeOrderByCreated(scope);

        model.addAttribute("mode", mode);
        model.addAttribute("selscope", scope);
        model.addAttribute("parents", parents);
        model.addAttribute("reports", reports);

        return this.pageSetup("archive", model, session);
    }


}
