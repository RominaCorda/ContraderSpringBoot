package it.com.ibm.generali.CapitalReporting.controller.web.admin;

import it.com.ibm.generali.CapitalReporting.CapitalReportingApplication;
import it.com.ibm.generali.CapitalReporting.controller.web.SessionHelper;
import it.com.ibm.generali.CapitalReporting.dao.TemplateDao;
import it.com.ibm.generali.CapitalReporting.model.Template;
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
public class TemplateController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(TemplateController.class);

    private TemplateDao templates;

    @Autowired
    public TemplateController(TemplateDao templateDao)
    {
        this.templates = templateDao;
    }

    /**
     * Templates with delete
     */
    @RequestMapping(value = "/templates", method = RequestMethod.GET, params = {"delete"})
    public String deleteTemplate(@RequestParam("delete") String roleId, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        this.templates.delete(Long.parseLong(roleId));
        return "redirect:templates";
    }

    /**
     * Templates GET
     */
    @RequestMapping("/templates")
    public String templates(Model model, HttpSession session)
    {
        logger.info("/templates page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        final Iterable<Template> templates = this.templates.findAll();

        model.addAttribute("templates", templates);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "templates";
    }

    /**
     * Templates POST
     */
    @RequestMapping(value = "/templates", method = RequestMethod.POST)
    public String addTemplate(@RequestParam("name") String name, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        logger.info("Received POST for description = " + name);

        Template newrole = new Template();
        newrole.setName(name);
        this.templates.save(newrole);

        return "redirect:templates";

    }


}

