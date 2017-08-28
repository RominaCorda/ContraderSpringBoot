package it.com.ibm.generali.CapitaliReporting.controller.web;

import it.com.ibm.generali.CapitaliReporting.CapitaliReportingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Home page Capitali Reporting controller
 */
@Controller
public class WebController extends SessionController
{

    private Logger logger = LoggerFactory.getLogger(WebController.class);

    private static final String APP_TITLE = "GENERALI ASSICURAZIONI";

    /**
     * the REST request for / resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/index")
    public String index(Model model, HttpSession session)
    {
        if (!this.isLogged(session))
        {
            return "redirect:login";
        }

        logger.info("/index page");
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", WebController.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "index";
    }

    /**
     * the REST request for / resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/report")
    public String report(Model model, HttpSession session)
    {
        if (!this.isLogged(session))
        {
            return "redirect:login";
        }

        logger.info("/report page");
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", WebController.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "report";
    }

    /**
     * the REST request for / resource.
     *
     * @return redirect to the index page
     **/
    @RequestMapping("/")
    public String home(HttpSession session)
    {
        return "redirect:index";
    }


}
