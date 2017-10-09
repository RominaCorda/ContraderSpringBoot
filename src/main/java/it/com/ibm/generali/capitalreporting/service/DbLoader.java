package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dao.*;
import it.com.ibm.generali.capitalreporting.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DbLoader implements ApplicationRunner
{
    private Logger logger = LoggerFactory.getLogger(DbLoader.class);
    private ScopeDao scopes;
    private ReportDao reports;
    private UserDao users;
    private RoleDao roles;
    private TemplateDao templates;
    private TagDao tags;
    private UserTagDao userTags;

    final private Random seed = new Random();

    @Autowired
    public DbLoader(ScopeDao scopeDao,
                    ReportDao reportDao,
                    UserDao userDao,
                    RoleDao roleDao,
                    TemplateDao templateDao,
                    TagDao tagDao,
                    UserTagDao userTagDao)
    {
        this.scopes = scopeDao;
        this.reports = reportDao;
        this.users = userDao;
        this.roles = roleDao;
        this.templates = templateDao;
        this.tags = tagDao;
        this.userTags = userTagDao;
    }

    public void run(ApplicationArguments args)
    {
        this.createRoles();
        this.createTemplates();
        this.createTags();
        this.createUsers();
        this.createScopesLevelRoot();
        List<Scope> level1 = this.createScopesLevelOne();
        List<Scope> level2 = this.createScopesLevelTwo(level1);
        this.addReportsToScopes(level2, 8);
    }

    private void createRoles()
    {
        logger.info("Creating default roles");
        List<String> roles = new ArrayList<>();
        roles.add("System Administrator");
        roles.add("Power CapitalUser");
        roles.add("Analyst CapitalUser");
        roles.add("Business CapitalUser");
        roles.add("Guest");
        for (String role : roles)
        {
            Role tempRole = new Role();
            tempRole.setDescription(role);
            this.roles.save(tempRole);
        }
    }

    private void createTemplates()
    {
        logger.info("Creating default templates");
        List<String> templates = new ArrayList<>();
        templates.add("Template 01");
        templates.add("Template 02");
        templates.add("Template 03");
        templates.add("Template 0x");
        for (String templ : templates)
        {
            Template temp = new Template();
            temp.setName(templ);
            this.templates.save(temp);
        }
    }

    private void createTags()
    {
        logger.info("Creating default tags");
        List<String> tags = new ArrayList<>();
        tags.add("Risk");
        tags.add("Life");
        tags.add("Auto");
        tags.add("Moto");
        tags.add("Fire");
        tags.add("Earthquake");
        tags.add("Vandalism");
        for (String templ : tags)
        {
            Tag temp = new Tag();
            temp.setName(templ);
            this.tags.save(temp);
        }

        logger.info("Creating default capitalUser tags");
        List<String> usertags = new ArrayList<>();
        usertags.add("Italy");
        usertags.add("Germany");
        usertags.add("Spain");
        usertags.add("Europe");
        usertags.add("World");
        usertags.add("Universe");
        for (String templ : usertags)
        {
            UserTag temp = new UserTag();
            temp.setName(templ);
            this.userTags.save(temp);
        }
    }

    private void createUsers()
    {
        logger.info("Creating default capitalUsers");
        Role admin = this.roles.findByDescription("System Administrator");
        Role analyst = this.roles.findByDescription("Analyst CapitalUser");
        List<CapitalUser> users = new ArrayList<>();
        users.add(new CapitalUser("admin", "pass", "Administrator", "admin@capitalireporting.info", admin));
        users.add(new CapitalUser("gian", "pass", "Gianmaria Borgonovo", "gian@capitalireporting.info", analyst));
        users.add(new CapitalUser("john", "pass", "John Brunello", "john@capitalireporting.info", analyst));
        users.add(new CapitalUser("lorenzo", "pass", "Lorenzo Brandimarte", "lorenzo@capitalireporting.info", analyst));
        users.add(new CapitalUser("michela", "pass", "Michela Da Ros", "michela@capitalireporting.info", analyst));
        users.add(new CapitalUser("alessio", "doctor", "Alessio Saltarin", "alessio@capitalireporting.info", analyst));
        this.users.save(users);
    }

    private CapitalUser getRandomUser()
    {
        final Iterable<CapitalUser> all = this.users.findAll();
        List<CapitalUser> users = new ArrayList<>();
        all.forEach(users::add);
        return users.get(this.seed.nextInt(users.size() - 1) + 1);
    }

    private void addReportsToScopes(List<Scope> scopes, int nrOfReports)
    {
        for (Scope s : scopes)
        {
            this.addReportsToScope(s, nrOfReports);
        }
    }

    private List<Scope> createScopesLevelTwo(List<Scope> parents)
    {
        logger.info("Creating scopes Level 2");
        String[] words = {"Group", "Germany", "Italy", "Italy Solo",
                "France", "Czech Republic", "Spain", "Spain Solo", "United Kingdom",
                "Finland", "Sweden", "Romania", "Croatia"};
        return this.createScopes(parents, words, words.length);
    }

    private List<Scope> createScopesLevelOne()
    {
        logger.info("Creating scopes Level 1");
        String[] words = {"Analyst Meeting", "Closure SCR", "ORSA Reports", "Final Esteem",
                "Convergence"};
        List<Scope> parents = (List<Scope>) this.scopes.findAll();
        return this.createScopes(parents, words, 5);
    }

    private void createScopesLevelRoot()
    {
        logger.info("Creating scopes Root Level");

        // Level -1
        for (int year = 2013; year < 2018; year++)
        {
            Scope tempScope = new Scope();
            tempScope.setName(String.valueOf("YE" + String.valueOf(year)));
            tempScope.setParent(-1L);
            tempScope.setPublished(true);
            this.scopes.save(tempScope);
        }
    }

    private void addReportsToScope(Scope scope, int nrOfReports)
    {
        int period = 2013 + this.seed.nextInt(4);
        for (int k = 0; k < nrOfReports; k++)
        {
            Report tempReport = this.createReport(scope, String.valueOf(period));
            scope.addReport(tempReport);
        }
    }

    private Report createReport(Scope parent, String period)
    {
        Report report = new Report();
        report.setScope(parent);
        report.setReportingPeriod(period);
        report.setSimulationId(seed.nextInt(99999));
        report.setTemplate("Template 0" + seed.nextInt(9));
        report.setCapitalUser(this.getRandomUser());
        this.reports.save(report);
        return report;
    }

    private List<Scope> createScopes(List<Scope> parents, String[] names, int maxItems)
    {
        List<Scope> createdScopes = new ArrayList<>();

        for (Scope parent : parents)
        {
            Set<String> scopeNames = new HashSet<>();
            for (int j = 0; j < seed.nextInt(maxItems) + 3; j++)
            {
                scopeNames.add(names[seed.nextInt(names.length)]);
            }

            for (String scopeName : scopeNames)
            {
                long parentScope = parent.getId();
                Scope tempScope = new Scope();
                tempScope.setName(scopeName);
                tempScope.setParent(parentScope);
                tempScope.setPublished(true);
                createdScopes.add(tempScope);
            }
        }

        this.scopes.save(createdScopes);
        return createdScopes;

    }
}