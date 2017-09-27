package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.TagDao;
import it.com.ibm.generali.capitalreporting.model.Tag;
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
public class TagController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(TagController.class);

    private TagDao tags;

    @Autowired
    public TagController(TagDao tagDao)
    {
        this.tags = tagDao;
    }

    /**
     * Tags with delete
     */
    @RequestMapping(value = "/tags", method = RequestMethod.GET, params = {"delete"})
    public String deleteTag(@RequestParam("delete") String tagId, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        this.tags.delete(Long.parseLong(tagId));
        return "redirect:tags";
    }

    /**
     * Roles GET
     */
    @RequestMapping("/tags")
    public String tags(Model model, HttpSession session)
    {
        logger.info("/tags page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        model.addAttribute("tags", this.tags.findAll());
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "tags";
    }

    /**
     * Roles POST
     */
    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public String addTag(@RequestParam("name") String name, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        logger.info("Received POST for name = " + name);

        Tag newTag = new Tag();
        newTag.setName(name);
        this.tags.save(newTag);

        return "redirect:tags";

    }


}

