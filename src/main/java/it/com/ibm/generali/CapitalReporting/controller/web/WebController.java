package it.com.ibm.generali.CapitalReporting.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Home page Capital Reporting controller
 */
@Controller
public class WebController extends SessionHelper
{

    private Logger logger = LoggerFactory.getLogger(WebController.class);

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
        logger.info("/index page");
        return this.pageSetup("index", model, session);
    }

    /**
     * the REST request for /profile resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the profile page
     */
    @RequestMapping("/profile")
    public String profile(Model model, HttpSession session)
    {
        logger.info("/profile page");
        return this.pageSetup("profile", model, session);
    }

    /**
     * the REST request for /profile resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the profile page
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET, params = {"error"})
    public String profileWithError(Model model, @RequestParam("error") String error, HttpSession session)
    {
        logger.info("/profile with error page");
        model.addAttribute("error", error);
        return this.pageSetup("profile", model, session);
    }

    /**
     * the REST request for /pwdchanged resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the password changed page
     */
    @RequestMapping("/pwdchanged")
    public String passwordChanges(Model model, HttpSession session)
    {
        logger.info("/pwdchanged page");
        return this.pageSetup("pwdchanged", model, session);
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
        logger.info("/report page");
        return this.pageSetup("report", model, session);
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
