package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dao.*;
import it.com.ibm.generali.capitalreporting.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class DbLoaderBase
{
    protected final Random seed = new Random();
    protected Logger logger = LoggerFactory.getLogger(DbLoaderBase.class);

    protected UserDao users;
    protected RoleDao roles;
    protected TemplateDao templates;
    protected PermissionDao permissions;
    protected NewsArticleDao news;

    @Autowired
    public DbLoaderBase(RoleDao roleDao,
                        TemplateDao templateDao,
                        PermissionDao permissionDao,
                        NewsArticleDao newsArticleDao,
                        UserDao userDao)
    {
        this.roles = roleDao;
        this.templates = templateDao;
        this.permissions = permissionDao;
        this.news = newsArticleDao;
        this.users = userDao;
    }

    protected void createNews()
    {
        logger.info("Creating news");

        NewsArticle news1 = new NewsArticle();
        news1.setTitle("Reporting is online!!");
        news1.setBody("Wow, reporting is online!");
        news1.setLinkTitle("Seemingly ready and blazingly fast.");
        news1.setLinkUrl("#");

        NewsArticle news2 = new NewsArticle();
        news2.setTitle("New report A32980 available");
        news2.setBody("It has an easy to override visual style, and is appropriately subdued.");
        news2.setLinkTitle("It's dangerous to go alone, take this.");
        news2.setLinkUrl("#");

        this.news.save(news1);
        this.news.save(news2);


    }

    protected void createRoles()
    {
        logger.info("Creating default roles");
        List<String> roles = new ArrayList<>();
        roles.add("System Administrator");
        roles.add("Power User");
        roles.add("Analyst User");
        roles.add("Business User");
        roles.add("Guest");
        Permission defaultPermission1 = this.permissions.findByDescription("Edit official reports");
        Permission defaultPermission2 = this.permissions.findByDescription("Manage official scope");
        Set<Permission> defaultPermissions = new HashSet<>();
        defaultPermissions.add(defaultPermission1);
        defaultPermissions.add(defaultPermission2);
        for (String role : roles)
        {
            Role tempRole = new Role();
            tempRole.setDescription(role);
            tempRole.setPermissions(defaultPermissions);
            this.roles.save(tempRole);
        }
    }

    protected void createTemplates()
    {
        logger.info("Creating default templates");
        List<String> templates = new ArrayList<>();
        templates.add("Template 01");
        templates.add("Template 02");
        templates.add("Template 03");
        templates.add("Template 0x");

        List<String> nodesId = new ArrayList<>();
        nodesId.add("DE012");
        nodesId.add("IT000");
        nodesId.add("BG301");
        nodesId.add("IT101");
        nodesId.add("FR501");

        int simulationId;
        for (String templ : templates)
        {
            simulationId = this.seed.nextInt(99999);
            Template temp = new Template();
            temp.setName(templ);
            temp.setSimulationId(String.valueOf(simulationId));
            temp.setNodeId(nodesId.get(this.seed.nextInt(nodesId.size())));
            this.templates.save(temp);
        }
    }

    protected void createUsers()
    {
        logger.info("Creating default capitalUsers");
        Role admin = this.roles.findByDescription("System Administrator");
        Role analyst = this.roles.findByDescription("Analyst User");
        Role power = this.roles.findByDescription("Power User");
        List<CapitalUser> users = new ArrayList<>();
        users.add(new CapitalUser("admin", "pass", "Administrator", "admin@capitalireporting.info", admin));
        users.add(new CapitalUser("gian", "pass", "Gianmaria Borgonovo", "gian@capitalireporting.info", analyst));
        users.add(new CapitalUser("john", "pass", "John Brunello", "john@capitalireporting.info", analyst));
        users.add(new CapitalUser("lorenzo", "pass", "Lorenzo Brandimarte", "lorenzo@capitalireporting.info", analyst));
        users.add(new CapitalUser("michela", "pass", "Michela Da Ros", "michela@capitalireporting.info", analyst));
        users.add(new CapitalUser("alessio", "doctor", "Alessio Saltarin", "alessio@capitalireporting.info", analyst));
        users.add(new CapitalUser("lorenzo", "pippo", "Lorenzo Valente", "lorenzo@capitalireporting.info", power));
        users.add(new CapitalUser("sabatino", "pass", "Sabatino Autorino", "sabatino@capitalireporting.info", power));

        this.users.save(users);
    }

    protected CapitalUser getRandomUser()
    {
        final Iterable<CapitalUser> all = this.users.findAll();
        List<CapitalUser> users = new ArrayList<>();
        all.forEach(users::add);
        return users.get(this.seed.nextInt(users.size() - 1) + 1);
    }

    protected Set<CapitalUser> getRandomUsers(int howmany)
    {
        Set<CapitalUser> users = new HashSet<>();
        for (int i = 0; i < howmany; i++)
        {
            users.add(this.getRandomUser());
        }
        return users;
    }

}
