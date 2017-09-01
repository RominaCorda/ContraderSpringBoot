package it.com.ibm.generali.CapitaliReporting.controller.web;

import it.com.ibm.generali.CapitaliReporting.CapitaliReportingApplication;
import it.com.ibm.generali.CapitaliReporting.dao.RoleDao;
import it.com.ibm.generali.CapitaliReporting.dao.UserDao;
import it.com.ibm.generali.CapitaliReporting.model.Role;
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

@Controller
public class AdminController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    private UserDao users;
    private RoleDao roles;

    @Autowired
    public AdminController(UserDao userDao, RoleDao roleDao)
    {
        this.users = userDao;
        this.roles = roleDao;
    }

    /**
     * Configure page GET with selected user
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"selecteduser"})
    public String configureWithUsername(Model model, HttpSession session, @RequestParam("selecteduser") String username)
    {
        logger.info("/configure page with selecteduser =" + username);
        return this.configureTemplate(model, session, username);
    }

    /**
     * the REST request for /configure resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the configure page
     */
    @RequestMapping("/configure")
    public String configure(Model model, HttpSession session)
    {
        logger.info("/configure page");
        return this.configureTemplate(model, session, "admin");
    }

    /**
     * Delete role page GET
     */
    @RequestMapping(value = "/roles", method = RequestMethod.GET, params = {"delete"})
    public String deleteRole(Model model, HttpSession session, @RequestParam("delete") String roleId)
    {
        this.roles.delete(Long.parseLong(roleId));
        return "redirect:roles";
    }

    /**
     * the REST request for /roles resource.
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the roles page
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
        model.addAttribute("title", CapitaliReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());

        return "roles";
    }

    /**
     * Login page POST
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

    private String configureTemplate(Model model, HttpSession session, String username)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        final Iterable<User> users = this.users.findAll();
        final Iterable<Role> roles = this.roles.findAll();
        final User selectedUser = this.users.findOne(username);

        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("selecteduser", selectedUser);
        model.addAttribute("title", CapitaliReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitaliReportingApplication.getVersion());

        return "configure";

    }

}
