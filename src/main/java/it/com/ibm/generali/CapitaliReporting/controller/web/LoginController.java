package it.com.ibm.generali.CapitaliReporting.controller.web;

import it.com.ibm.generali.CapitaliReporting.CapitaliReportingApplication;
import it.com.ibm.generali.CapitaliReporting.dao.UserDao;
import it.com.ibm.generali.CapitaliReporting.model.User;
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
 * Login Capitali Reporting controller
 */
@Controller
public class LoginController extends SessionController
{

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private UserDao users;

    @Autowired
    public LoginController(UserDao userDao)
    {
        this.users = userDao;
    }

    /**
     * Login page GET with error message
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, params = {"error"})
    public String loginWithError(Model model, @RequestParam("error") String error)
    {
        logger.info("/login page with error =" + error);

        model.addAttribute("error", error);
        model.addAttribute("title", CapitaliReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "login";
    }

    /**
     * Login page GET
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session)
    {
        logger.info("/login page");

        if (session.getAttribute("loggedUser") != null)
        {
            logger.warn("A user is already logged!");
            return "redirect:index";
        }

        this.listKnownUsers();

        model.addAttribute("title", CapitaliReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());
        return "login";
    }

    /**
     * Logout page GET
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session)
    {
        logger.info("/logout page");

        if (session.getAttribute("loggedUser") != null)
        {
            session.removeAttribute("loggedUser");
        }

        return "redirect:login";
    }

    /**
     * Login page POST
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password, HttpSession session)
    {
        String errorMsg;

        logger.info("Received POST for user = " + username);
        logger.info("Received password = " + password);

        User knownUser = this.users.findOne(username);
        if (knownUser != null)
        {
            logger.info("Ok, found user " + username);
            if (knownUser.getPassword().equals(password))
            {
                logger.info("Password is OK");
                this.saveUserSession(session, knownUser);
                return "redirect:index";
            }
            else
            {
                errorMsg = "Wrong password";
            }
        }
        else
        {
            errorMsg = "Unknown user";
        }

        logger.error(errorMsg);
        return "redirect:/login?error=" + errorMsg;

    }

    private void listKnownUsers()
    {
        this.logger.info("Known users: ");
        for (User user : this.users.findAll())
        {
            this.logger.info(">> " + user);
        }
    }


}

