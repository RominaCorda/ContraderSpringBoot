package it.com.ibm.generali.capitalreporting.controller.web;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class SessionHelper
{

    protected static final String LOGGED_USER = "loggedUser";

    protected CapitalUser getCurrentUser(HttpSession session)
    {
        if (session.getAttribute(LOGGED_USER) != null)
        {
            return (CapitalUser) session.getAttribute(LOGGED_USER);
        }

        return null;
    }

    protected void saveUserSession(HttpSession session, CapitalUser user)
    {
        session.setAttribute(LOGGED_USER, user);
    }

    protected boolean isAdmin(HttpSession session)
    {
        if (session.getAttribute(LOGGED_USER) != null)
        {
            CapitalUser currentUser = (CapitalUser) session.getAttribute(LOGGED_USER);
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
