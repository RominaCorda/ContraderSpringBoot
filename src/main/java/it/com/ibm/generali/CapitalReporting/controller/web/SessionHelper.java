package it.com.ibm.generali.CapitalReporting.controller.web;

import it.com.ibm.generali.CapitalReporting.CapitalReportingApplication;
import it.com.ibm.generali.CapitalReporting.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class SessionHelper
{

    protected static final String LOGGED_USER = "loggedUser";

    protected User getCurrentUser(HttpSession session)
    {
        if (session.getAttribute(LOGGED_USER) != null)
        {
            return (User) session.getAttribute(LOGGED_USER);
        }

        return null;
    }

    protected void saveUserSession(HttpSession session, User user)
    {
        session.setAttribute(LOGGED_USER, user);
    }

    protected boolean isAdmin(HttpSession session)
    {
        if (session.getAttribute(LOGGED_USER) != null)
        {
            User currentUser = (User) session.getAttribute(LOGGED_USER);
            if (currentUser.username.equals("admin"))
                return true;
        }
        return false;
    }

    protected boolean isLogged(HttpSession session)
    {
        return (this.getCurrentUser(session) != null);
    }

    protected String pageSetup(String template, Model model, HttpSession session)
    {
        if (!this.isLogged(session))
        {
            return "redirect:login";
        }

        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return template;

    }

    protected String pageSetup(String template, Model model)
    {
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());
        return template;
    }

}
