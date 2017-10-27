package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.PermissionDao;
import it.com.ibm.generali.capitalreporting.dao.RoleDao;
import it.com.ibm.generali.capitalreporting.model.Permission;
import it.com.ibm.generali.capitalreporting.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class RoleController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    private RoleDao roles;
    private PermissionDao permissions;

    @Autowired
    public RoleController(RoleDao roleDao,
                          PermissionDao permissionDao)
    {
        this.roles = roleDao;
        this.permissions = permissionDao;
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
     * Edit Role GET
     */
    @RequestMapping(value = "/editrole", method = RequestMethod.GET, params = {"roleid"})
    public String editRole(Model model, HttpSession session, @RequestParam("roleid") long roleId)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        logger.info("/editrole for role=" + String.valueOf(roleId));
        Role role = this.roles.findOne(roleId);
        model.addAttribute("role", role);

        Set<Long> permissionIds = new HashSet<>();
        Iterable<Permission> permissions = this.permissions.findAll();
        for (Permission permission : role.getPermissions())
        {
            logger.info("Role has permission > " + permission.getDescription());
            permissionIds.add(permission.getId());
        }
        model.addAttribute("permissionsIds", permissionIds);
        model.addAttribute("permissions", permissions);
        return this.pageSetup("editrole", model, session);
    }

    /**
     * Edit Role POST
     */
    @RequestMapping(value = "/editrole", method = RequestMethod.POST)
    public String modifyRole(Model model, HttpSession session,
                             @RequestParam("roleid") long roleId,
                             @RequestParam("rolename") String roleName,
                             @RequestParam("rolepermissions") String[] rolePermissions)
    {
        logger.info("/editrole POST for role=" + String.valueOf(roleId));
        Set<Permission> permissions = new HashSet<>();
        for (String perm : rolePermissions)
        {
            permissions.add(this.permissions.findByDescription(perm));
        }
        Role role = this.roles.findOne(roleId);
        role.setDescription(roleName);
        role.setPermissions(permissions);
        this.roles.save(role);
        return "redirect:editrole?roleid=" + roleId;
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
