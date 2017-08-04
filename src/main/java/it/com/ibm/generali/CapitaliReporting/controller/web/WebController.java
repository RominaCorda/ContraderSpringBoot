package it.com.ibm.generali.CapitaliReporting.controller.web;

import it.com.ibm.generali.CapitaliReporting.CapitaliReportingApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page EluxCommander controller
 */
@Controller
public class WebController
{

    private static final String APP_TITLE = "GENERALI ASSICURAZIONI";

    /**
     * the REST request for / resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("title", WebController.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "login";
    }

    /**
     * the REST request for / resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("title", WebController.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "index";
    }

    /**
     * the REST request for / resource.
     *
     * @return redirect to the index page
     **/
    @RequestMapping("/")
    public String home()
    {
        // If already logged in....
        return "redirect:login";
    }


}
