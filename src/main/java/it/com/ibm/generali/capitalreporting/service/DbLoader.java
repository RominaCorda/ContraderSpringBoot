package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dao.*;
import it.com.ibm.generali.capitalreporting.model.*;
import org.jetbrains.annotations.NotNull;
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
    private SimulationDao simulations;
    private PermissionDao permissions;
    private NewsArticleDao news;

    final private Random seed = new Random();

    @Autowired
    public DbLoader(ScopeDao scopeDao,
                    ReportDao reportDao,
                    UserDao userDao,
                    RoleDao roleDao,
                    TemplateDao templateDao,
                    TagDao tagDao,
                    UserTagDao userTagDao,
                    SimulationDao simulationDao,
                    PermissionDao permissionDao,
                    NewsArticleDao newsArticleDao)
    {
        this.scopes = scopeDao;
        this.reports = reportDao;
        this.users = userDao;
        this.roles = roleDao;
        this.templates = templateDao;
        this.tags = tagDao;
        this.userTags = userTagDao;
        this.simulations = simulationDao;
        this.permissions = permissionDao;
        this.news = newsArticleDao;
    }

    public void run(ApplicationArguments args)
    {
        if (this.permissions.count() == 0)
        {
            this.createPermissions();
        }

        if (this.roles.count() == 0)
        {
            this.createRoles();
        }

        if (this.templates.count() == 0)
        {
            this.createTemplates();
        }

        if (this.tags.count() == 0)
        {
            this.createTags();
        }

        if (this.users.count() == 0)
        {
            this.createUsers();
        }

        if (this.simulations.count() == 0)
        {
            this.createSimulations();
        }

        if (this.scopes.count() == 0)
        {
            this.createScopesLevelRoot(ScopeType.ANALYSIS);
            this.createScopesLevelRoot(ScopeType.OFFICIAL);

            List<Scope> level1Analysis = this.createScopesLevelOne(ScopeType.ANALYSIS);
            List<Scope> level1Official = this.createScopesLevelOne(ScopeType.OFFICIAL);

            List<Scope> level2Official = this.createScopesLevelTwo(ScopeType.OFFICIAL, level1Official);
            List<Scope> level2Analysis = this.createScopesLevelTwo(ScopeType.ANALYSIS, level1Analysis);

            this.addReportsToScopes(level2Official, 8);
            this.addReportsToScopes(level2Analysis, 8);
        }

        if (this.news.count() == 0)
        {
            this.createNews();
        }

    }

    private void createPermissions()
    {
        logger.info("Creating permissions");
        List<String> permissions = new ArrayList<>();
        permissions.add("Configure Users");
        permissions.add("Manage application role");
        permissions.add("Manage templates");
        permissions.add("Manage analysis scope");
        permissions.add("Manage official scope");
        permissions.add("Manage simulations");
        permissions.add("Edit free reporting page");
        permissions.add("Edit analysis reports");
        permissions.add("Edit official reports");
        for (String permission : permissions)
        {
            Permission tempPermission = new Permission();
            tempPermission.setDescription(permission);
            this.permissions.save(tempPermission);
        }
    }

    private void createNews()
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

    private void createRoles()
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

    private void createSimulations()
    {
        logger.info("Creating simulations");
        Simulation tmpSimulation;
        CapitalUser user = this.users.findAll().iterator().next();

        List<String> reportingPeriod = new ArrayList<>();
        reportingPeriod.add("YE2014");
        reportingPeriod.add("YE2015");
        reportingPeriod.add("YE2016");
        reportingPeriod.add("YE2017");

        for (int j = 1; j <= 40; j++)
        {
            int repPeriodIdx = this.seed.nextInt(reportingPeriod.size());
            tmpSimulation = new Simulation();
            tmpSimulation.setName("Simulation " + String.valueOf(j));
            tmpSimulation.setUser(user);
            tmpSimulation.setOfficial(true);
            tmpSimulation.setReportingPeriod(reportingPeriod.get(repPeriodIdx));
            this.simulations.save(tmpSimulation);
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

        logger.info("Creating default user tags");
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

    private List<Scope> createScopesLevelTwo(ScopeType type, List<Scope> parents)
    {
        logger.info("Creating scopes Level 2 (" + type.toString() + ")");
        List<Scope> created;

        if (type == ScopeType.OFFICIAL)
        {
            String[] words = {"Group", "German", "Italy", "Italy Solo", "France", "Czech Republic"};
            created = this.createScopes(type, parents, words);
        }
        else
        {
            String[] words = {"Head Office", "Germany", "Italy", "Italy Solo",
                    "France", "Czach Republic", "Non Life specific"};
            created = this.createScopes(type, parents, words);
        }

        return created;
    }

    private List<Scope> createScopesLevelOne(ScopeType type)
    {
        logger.info("Creating scopes Level 1(" + type.toString() + ")");
        List<Scope> created = null;

        if (type == ScopeType.OFFICIAL)
        {
            String[] words = {"Analyst Meeting", "Closure SCR", "ORSA Reports", "Convergence"};
            List<Scope> parents = (List<Scope>) this.scopes.findByType(type);
            created = this.createScopes(type, parents, words);
        }
        else
        {
            String[] words = {"Group Run 1", "German Trials", "Italy Trials", "France Trials",
                    "Czech Trials"};
            List<Scope> parents = this.scopes.findByType(type);
            created = this.createScopes(type, parents, words);
        }

        return created;
    }

    private void createScopesLevelRoot(ScopeType type)
    {
        logger.info("Creating scopes Root Level (" + type.toString() + ")");

        // Level -1
        for (int year = 2014; year < 2018; year++)
        {
            Scope tempScope = new Scope();
            tempScope.setName(String.valueOf("YE" + String.valueOf(year)));
            tempScope.setParent(-1L);
            tempScope.setPublished(true);
            tempScope.setType(type);
            this.scopes.save(tempScope);
        }
    }

    private void addReportsToScope(Scope scope, int nrOfReports)
    {
        int period = 2013 + this.seed.nextInt(4);
        Iterator<Template> allTemplates = this.templates.findAll().iterator();
        for (int k = 0; k < nrOfReports; k++)
        {
            Template template;
            if (!allTemplates.hasNext())
            {
                allTemplates = this.templates.findAll().iterator();
            }
            template = allTemplates.next();
            Report tempReport = this.createReport(scope, String.valueOf(period), template);
            scope.addReport(tempReport);
        }
    }

    private Report createReport(Scope parent, String period, Template template)
    {
        Report report = new Report();
        int nrReport = this.seed.nextInt(999);
        report.setName("Report #" + String.valueOf(nrReport));
        report.setScope(parent);
        report.setReportingPeriod(period);
        report.setTemplate(template);
        report.setUser(this.getRandomUser());
        this.reports.save(report);
        return report;
    }

    private List<Scope> createScopes(ScopeType type,
                                     List<Scope> parents,
                                     String[] names)
    {
        List<Scope> createdScopes = new ArrayList<>();
        for (Scope parent : parents)
        {
            for (String scopeName : names)
            {
                createdScopes.add(createScope(type, parent, scopeName));
            }
        }
        this.scopes.save(createdScopes);
        return createdScopes;

    }

    @NotNull
    private Scope createScope(ScopeType type, Scope parent, String scopeName)
    {
        long parentScope = parent.getId();
        Scope tempScope = new Scope();
        tempScope.setName(scopeName);
        tempScope.setType(type);
        tempScope.setParent(parentScope);
        tempScope.setPublished(true);
        return tempScope;
    }

}