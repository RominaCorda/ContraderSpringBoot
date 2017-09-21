package it.com.ibm.generali.CapitalReporting.controller.web.admin;

import it.com.ibm.generali.CapitalReporting.CapitalReportingApplication;
import it.com.ibm.generali.CapitalReporting.controller.web.SessionHelper;
import it.com.ibm.generali.CapitalReporting.dao.RoleDao;
import it.com.ibm.generali.CapitalReporting.dao.UserDao;
import it.com.ibm.generali.CapitalReporting.model.Role;
import it.com.ibm.generali.CapitalReporting.model.User;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ConfigureController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(ConfigureController.class);

    private UserDao users;
    private RoleDao roles;

    @Autowired
    public ConfigureController(UserDao userDao, RoleDao roleDao)
    {
        this.users = userDao;
        this.roles = roleDao;
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
        return this.configureTemplate(model, session, "none");
    }

    /**
     * Configure GET with selected user
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"selecteduser"})
    public String configureWithUsername(Model model, HttpSession session, @RequestParam("selecteduser") String username)
    {
        logger.info("/configure page with selecteduser =" + username);
        return this.configureTemplate(model, session, username);
    }

    /**
     * Configure GET with mode
     */
    @RequestMapping(value = "/configure", method = RequestMethod.GET, params = {"mode"})
    public String configureWithMode(Model model, @RequestParam("mode") String mode, HttpSession session)
    {
        logger.info("/configure GET with mode=" + mode);
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
     * Add or modify user
     */
    @RequestMapping(value = "/configure", method = RequestMethod.POST)
    public String addOrModifyUser(@ModelAttribute("user") User user)
    {
        logger.info("/configure POST");
        String username = user.getUsername();
        String mode;

        User modUser = this.users.findOne(username);
        if (modUser != null)
        {
            modUser.setEmail(user.getEmail());
            modUser.setFullName(user.getFullName());
            modUser.setActive(user.getActive());
            modUser.setRole(user.getRole());
            mode = "ok_modified";
        }
        else
        {
            modUser = User.Factory.copy(user);
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

        final Iterable<User> users = this.users.findAll();
        final Iterable<Role> roles = this.roles.findAll();

        List<User> allUsersExceptAdmin = new ArrayList<>();
        users.forEach(allUsersExceptAdmin::add);
        allUsersExceptAdmin = allUsersExceptAdmin.stream().filter(
                user -> !user.username.equals("admin")).collect(Collectors.toList());
        User selectedUser = allUsersExceptAdmin.iterator().next();

        if (mode.equals("new"))
        {
            selectedUser = new User();
            selectedUser.username = "";
            selectedUser.password = "";
            selectedUser.email = "";
            selectedUser.fullName = "";
            selectedUser.role = roles.iterator().next();
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
