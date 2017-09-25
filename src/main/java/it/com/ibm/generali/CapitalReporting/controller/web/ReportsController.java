package it.com.ibm.generali.CapitalReporting.controller.web;

import it.com.ibm.generali.CapitalReporting.dao.ScopeDao;
import it.com.ibm.generali.CapitalReporting.model.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class ReportsController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ReportsController.class);

    private ScopeDao scopes;

    @Autowired
    public ReportsController(ScopeDao scopeDao)
    {
        this.scopes = scopeDao;
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
        List<Scope> scopesZero = this.scopes.findByParent(-1);
        model.addAttribute("scopes", scopesZero);
        return this.pageSetup("browse", model, session);
    }

    /**
     * Months GET
     */
    @RequestMapping(value = "/scopes", method = RequestMethod.GET, params = {"parent"})
    public String scopes(Model model, @RequestParam("parent") Long parentId, HttpSession session)
    {
        logger.info("/Scopes for parent = " + parentId);
        List<Scope> scopes = this.scopes.findByParent(parentId);
        Scope parent = this.scopes.findOne(parentId);
        model.addAttribute("parent", parent);
        model.addAttribute("scopes", scopes);
        return this.pageSetup("scopes", model, session);
    }

    /**
     * Months GET
     */
    @RequestMapping(value = "/archive", method = RequestMethod.GET, params = {"parent", "scope"})
    public String archive(Model model,
                          @RequestParam("parent") Long parentId,
                          @RequestParam("scope") Long scopeId, HttpSession session)
    {
        logger.info("/Archive page for parent ID = " + parentId + " and scope ID = " + scopeId);

        Scope parent = this.scopes.findOne(parentId);
        Scope scope = this.scopes.findOne(scopeId);

        Random seed = new Random();

        String[] words = {"Group", "Germany", "Italy", "Italy Solo",
                "France", "Czech Republic", "Spain", "Spain Solo", "United Kingdom",
                "Finland", "Sweden", "Romania", "Croatia"};

        Map<String, String> archive = new HashMap<>();
        int numberOfReports = seed.nextInt(10) + 2;
        for (int j = 0; j < numberOfReports; j++)
        {
            String title = words[seed.nextInt(words.length)];
            String reportID = String.valueOf(seed.nextInt(100000));
            archive.put(title, reportID);
        }

        model.addAttribute("parent", parent);
        model.addAttribute("scope", scope);
        model.addAttribute("archive", archive);

        return this.pageSetup("archive", model, session);
    }


}
