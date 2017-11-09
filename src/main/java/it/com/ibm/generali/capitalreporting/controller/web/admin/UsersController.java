package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.RoleDao;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.dao.UserTagDao;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import it.com.ibm.generali.capitalreporting.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UsersController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(UsersController.class);

    private UserDao users;
    private RoleDao roles;
    private UserTagDao tags;

    @Autowired
    public UsersController(UserDao userDao, RoleDao roleDao, UserTagDao tagDao)
    {
        this.users = userDao;
        this.roles = roleDao;
        this.tags = tagDao;
    }

    /**
     * Configure GET
     *
     * @param model the HTTP request attributes. it will updated
     *              with application's version.
     * @return the configure page
     */
    @RequestMapping("/configure")
    public String configure(Model model, HttpSession session)
    {
        logger.info("/configure GET");
        model.addAttribute("tags", this.tags.findAll());
        return this.configureTemplate(model, session, "none");
    }

    /**
     * Configure GET with selected User
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"selecteduser"})
    public String configureWithUsername(Model model, HttpSession session, @RequestParam("selecteduser") String username)
    {
        logger.info("/configure page with selecteduser =" + username);
        model.addAttribute("tags", this.tags.findAll());
        return this.configureTemplate(model, session, username);
    }

    /**
     * Configure GET with mode
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"mode"})
    public String configureWithMode(Model model, @RequestParam("mode") String mode, HttpSession session)
    {
        logger.info("/configure GET with mode=" + mode);
        model.addAttribute("tags", this.tags.findAll());
        return this.configureTemplate(model, session, mode);
    }

    /**
     * Configure GET with delete
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"delete"})
    public String deleteUser(Model model, HttpSession session, @RequestParam("delete") String username)
    {
        this.users.delete(username);
        return "redirect:configure?mode=ok_deleted";
    }

    /**
     * Configure POST
     * Add or modify User
     */
    @RequestMapping(value = "/configure", method = RequestMethod.POST)
    public String addOrModifyUser(@ModelAttribute("user") CapitalUser user)
    {
        logger.info("/configure POST");
        String username = user.getUsername();
        String mode;

        for (Role r : user.getRoles())
        {
            logger.info("New role: " + r.getDescription());
        }

        CapitalUser modUser = this.users.findOne(username);
        if (modUser != null)
        {
            modUser.setEmail(user.getEmail());
            modUser.setFullName(user.getFullName());
            modUser.setActive(user.getActive());
            modUser.setRoles(user.getRoles());
            mode = "ok_modified";
        }
        else
        {
            modUser = CapitalUser.Factory.copy(user);
            mode = "ok_added";
        }

        this.users.save(modUser);
        return "redirect:configure?mode=" + mode;
    }

    private String configureTemplate(Model model, HttpSession session, String mode)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        final Iterable<CapitalUser> users = this.users.findAll();
        final Iterable<Role> roles = this.roles.findAll();

        List<CapitalUser> allUsersExceptAdmin = new ArrayList<>();
        users.forEach(allUsersExceptAdmin::add);
        allUsersExceptAdmin = allUsersExceptAdmin.stream().filter(
                user -> !user.username.equals("admin")).collect(Collectors.toList());
        CapitalUser selectedUser = allUsersExceptAdmin.iterator().next();

        if (mode.equals("new"))
        {
            selectedUser = new CapitalUser();
            selectedUser.username = "";
            selectedUser.email = "";
            selectedUser.fullName = "";
            HashSet<Role> defaultRoles = new HashSet<>();
            defaultRoles.add(roles.iterator().next());
            selectedUser.setRoles(defaultRoles);
            selectedUser.setActive(false);
        }
        else
        {
            if (!mode.equals("none"))
            {
                selectedUser = this.users.findOne(mode);
                if (selectedUser == null)
                {
                    selectedUser = allUsersExceptAdmin.iterator().next();
                }
            }
        }

        model.addAttribute("users", allUsersExceptAdmin);
        model.addAttribute("mode", mode);
        model.addAttribute("roles", roles);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("selecteduser", selectedUser);
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "configure";

    }


}
