package it.com.ibm.generali.CapitalReporting.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ReportsController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ReportsController.class);

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
        logger.info("/browse page");

        List<Integer> years = new ArrayList<>();
        for (int year = 2012; year < 2018; year++)
        {
            years.add(year);
        }
        model.addAttribute("years", years);

        return this.pageSetup("browse", model, session);
    }

    /**
     * Months GET
     */
    @RequestMapping(value = "/months", method = RequestMethod.GET, params = {"year"})
    public String months(Model model, @RequestParam("year") String year, HttpSession session)
    {
        logger.info("/Months page for year = " + year);

        List<String> months = new ArrayList<>();
        months.add("Analyst Meeting");
        months.add("Closure SCR");
        months.add("ORSA Reports");
        months.add("Convergence");

        model.addAttribute("year", year);
        model.addAttribute("months", months);

        return this.pageSetup("months", model, session);
    }

    /**
     * Months GET
     */
    @RequestMapping(value = "/archive", method = RequestMethod.GET, params = {"year", "month"})
    public String archive(Model model, @RequestParam("year") String year,
                          @RequestParam("month") String month, HttpSession session)
    {
        logger.info("/Archive page for year = " + year + " and month = " + month);

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

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("archive", archive);

        return this.pageSetup("archive", model, session);
    }


}
