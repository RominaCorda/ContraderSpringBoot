package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.TemplateDao;
import it.com.ibm.generali.capitalreporting.model.Template;
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
    public TemplateController(TemplateDao roleDao)
    {
        this.templates = roleDao;
    }

    /**
     * Template DELETE
     */
    @RequestMapping(value = "/templates", method = RequestMethod.GET, params = {"delete"})
    public String deleteTemplate(@RequestParam("delete") String templateId, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        this.templates.delete(Long.parseLong(templateId));
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

        model.addAttribute("templates", this.templates.findAll());
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "templates";
    }

    /**
     * Templates POST
     */
    @RequestMapping(value = "/templates", method = RequestMethod.POST)
    public String addRole(@RequestParam("name") String name, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        logger.info("Received POST for template = " + name);

        Template newtemplate = new Template();
        newtemplate.setName(name);
        this.templates.save(newtemplate);

        return "redirect:templates";

    }


}
