package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.SimulationDao;
import it.com.ibm.generali.capitalreporting.model.Simulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SimulationController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(SimulationController.class);

    private SimulationDao simulations;

    @Autowired
    public SimulationController(SimulationDao roleDao)
    {
        this.simulations = roleDao;
    }

    /**
     * Manage simulations initial page GET
     */
    @RequestMapping("/simulations")
    public String simulations(Model model,
                              HttpSession session)
    {
        return "redirect:/simulations?year=YE2014";
    }

    /**
     * Manage simulations initial page GET with YEAR
     */
    @RequestMapping(value = "/simulations", method = RequestMethod.GET, params = {"year"})
    public String simulations(Model model,
                              @RequestParam("year") String year,
                              HttpSession session)
    {
        logger.info("/simulations YEAR=" + year);

        List<String> reportingPeriods = new ArrayList<>();
        reportingPeriods.add("YE2014");
        reportingPeriods.add("YE2015");
        reportingPeriods.add("YE2016");
        reportingPeriods.add("YE2017");

        List<Simulation> simulations = this.simulations.findByReportingPeriod(year);

        model.addAttribute("reportingperiod", year);
        model.addAttribute("reportingperiods", reportingPeriods);
        model.addAttribute("simulations", simulations);

        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "simulations";
    }
}
