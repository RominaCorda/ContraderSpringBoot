package it.com.ibm.generali.CapitalReporting.controller.web.admin;

import it.com.ibm.generali.CapitalReporting.CapitalReportingApplication;
import it.com.ibm.generali.CapitalReporting.controller.web.SessionHelper;
import it.com.ibm.generali.CapitalReporting.dao.RoleDao;
import it.com.ibm.generali.CapitalReporting.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RoleController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    private RoleDao roles;

    @Autowired
    public RoleController(RoleDao roleDao)
    {
        this.roles = roleDao;
    }

    /**
     * Roles with delete
     */
    @RequestMapping(value = "/roles", method = RequestMethod.GET, params = {"delete"})
    public String deleteRole(@RequestParam("delete") String roleId, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        this.roles.delete(Long.parseLong(roleId));
        return "redirect:roles";
    }

    /**
     * Roles GET
     */
    @RequestMapping("/roles")
    public String roles(Model model, HttpSession session)
    {
        logger.info("/roles page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        final Iterable<Role> roles = this.roles.findAll();

        model.addAttribute("roles", roles);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "roles";
    }

    /**
     * Roles POST
     */
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public String addRole(@RequestParam("description") String description, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        logger.info("Received POST for description = " + description);

        Role newrole = new Role();
        newrole.setDescription(description);
        this.roles.save(newrole);

        return "redirect:roles";

    }


}
