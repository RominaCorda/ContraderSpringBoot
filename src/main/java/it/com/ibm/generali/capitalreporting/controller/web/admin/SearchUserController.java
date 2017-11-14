package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.dao.UserTagDao;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import it.com.ibm.generali.capitalreporting.model.UserTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Controller
public class SearchUserController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(SearchUserController.class);

    private UserDao users;
    private UserTagDao tags;

    @Autowired
    public SearchUserController(UserDao userDao, UserTagDao userTagDao)
    {
        this.users = userDao;
        this.tags = userTagDao;
    }

    /**
     * Search users
     */
    @RequestMapping(value = "/searchusers", method = RequestMethod.GET)
    public String searchusers(Model model, HttpSession session)
    {
        List<CapitalUser> users = new ArrayList<>();
        this.users.findAll().forEach(users::add);
        model.addAttribute("users", users);
        return this.configureTemplate(model, session);
    }

    /**
     * Search users with part of name
     */
    @RequestMapping(value = "/searchusers", method = RequestMethod.POST, params = {"name", "tags"})
    public String searchusers(Model model,
                              HttpSession session,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "tags", required = false) String tags)
    {

        List<CapitalUser> users = new ArrayList<>();

        if ((name.equals("")) && (tags.equals("")))
        {
            this.users.findAll().forEach(users::add);
        }
        else
        {
            if ((!name.equals("")) && (!tags.equals("")))
            {
                List<UserTag> foundtags = this.getTagsFromString(tags);
                users = this.users.findByUsernameLikeAndUsertagsIn(name, foundtags);
            }
            else
            {
                if (!name.equals(""))
                {
                    users = this.users.findByUsernameLike(name);
                }
                if (!tags.equals(""))
                {
                    users = this.users.findByUsertagsIn(this.getTagsFromString(tags));
                }
            }
        }

        model.addAttribute("users", users);
        return this.configureTemplate(model, session);
    }

    private List<UserTag> getTagsFromString(String tags)
    {
        List<UserTag> usertags = new ArrayList<>();
        if (tags.contains(","))
        {
            StringTokenizer st = new StringTokenizer(tags, ",");
            while (st.hasMoreTokens())
            {
                usertags.add(this.tags.findByNameIgnoreCase(st.nextToken().trim()));
            }
        }
        else
        {
            UserTag foundtag = this.tags.findByNameIgnoreCase(tags.trim());
            if (foundtag != null)
            {
                usertags.add(foundtag);
            }
        }
        return usertags;
    }

    private String configureTemplate(Model model,
                                     HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());
        return "searchusers";
    }


}
