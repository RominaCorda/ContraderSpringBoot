package it.com.ibm.generali.capitalreporting.controller.web;

import it.com.ibm.generali.capitalreporting.dao.ReportDao;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ReportDao reports;
    private UserDao users;

    @Autowired
    public WebController(ReportDao reportDao,
                         UserDao userDao)
    {
        this.reports = reportDao;
        this.users = userDao;
    }

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
        CapitalUser currentUser = this.getCurrentUser(session);
        model.addAttribute("reports", this.reports.findTop5ByUserOrderByCreated(currentUser));
        return this.pageSetup("index", model, session);
    }

    /**
     * the REST request for /search resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/search")
    public String search(Model model, HttpSession session)
    {
        logger.info("/search page");
        model.addAttribute("users", this.users.findAll());
        return this.pageSetup("search", model, session);
    }

    /**
     * the REST request for /searchresults resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the home page
     */
    @RequestMapping("/searchresults")
    public String searchResults(Model model, HttpSession session)
    {
        logger.info("/searchresults page");
        return this.pageSetup("searchresults", model, session);
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
     * @return redirect to the index page
     **/
    @RequestMapping("/")
    public String home(HttpSession session)
    {
        return "redirect:index";
    }




}
