package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.NewsArticleDao;
import it.com.ibm.generali.capitalreporting.model.NewsArticle;
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
public class NewsController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(NewsController.class);

    private NewsArticleDao news;

    @Autowired
    public NewsController(NewsArticleDao newsArticleDao)
    {
        this.news = newsArticleDao;
    }

    /**
     * Roles GET
     */
    @RequestMapping("/editnews")
    public String roles(Model model, HttpSession session)
    {
        logger.info("/editnews page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        final Iterable<NewsArticle> roles = this.news.findAll();

        model.addAttribute("newslist", roles);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "editnews";
    }

    /**
     * EditNews delete
     */
    @RequestMapping(value = "/editnews", method = RequestMethod.GET, params = {"delete"})
    public String deleteNews(@RequestParam("delete") String roleId, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        this.news.delete(Long.parseLong(roleId));
        return "redirect:editnews";
    }

    /**
     * Roles GET
     */
    @RequestMapping("/addnewsarticle")
    public String addnews(Model model, HttpSession session)
    {
        logger.info("/addnewsarticle page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        NewsArticle article = new NewsArticle();
        article = this.news.save(article);
        logger.info("Created new article #" + article.getId());

        return "redirect:editnewsarticle?newsid=" + article.getId();
    }

    /**
     * Edit Single News
     */
    @RequestMapping(value = "/editnewsarticle", method = RequestMethod.GET, params = {"newsid"})
    public String editNewsArticle(@RequestParam("newsid") String newsId, Model model, HttpSession session)
    {
        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        long articleId = Long.parseLong(newsId);
        NewsArticle newsArticle = this.news.findOne(articleId);
        model.addAttribute("newsarticle", newsArticle);
        model.addAttribute("user", this.getCurrentUser(session));
        model.addAttribute("title", CapitalReportingApplication.APP_TITLE);
        model.addAttribute("version", CapitalReportingApplication.getVersion());

        return "editnewsarticle";
    }

    /**
     * Edit News POST
     */
    @RequestMapping(value = "/editnewsarticle", method = RequestMethod.POST)
    public String modifyRole(Model model, HttpSession session,
                             @RequestParam("newsid") long newsId,
                             @RequestParam("title") String newsTitle,
                             @RequestParam("body") String newsBody,
                             @RequestParam("linkUrl") String newsLinkUrl,
                             @RequestParam("linkTitle") String newsLinkTitle,
                             @RequestParam("published") Boolean isPublished)
    {
        logger.info("/editnewsarticle POST for article=" + String.valueOf(newsId));
        NewsArticle newsArticle = this.news.findOne(newsId);
        newsArticle.setTitle(newsTitle);
        newsArticle.setBody(newsBody);
        if (newsLinkTitle.length() > 3)
        {
            newsArticle.setLinkTitle(newsLinkTitle);
            newsArticle.setLinkUrl(newsLinkUrl);
        }
        newsArticle.setPublished(isPublished);
        this.news.save(newsArticle);
        logger.info("Updated article #" + String.valueOf(newsId));
        return "redirect:editnews";
    }

}
