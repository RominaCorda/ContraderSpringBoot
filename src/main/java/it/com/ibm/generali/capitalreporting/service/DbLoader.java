package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dao.*;
import it.com.ibm.generali.capitalreporting.model.*;
import org.hibernate.collection.internal.PersistentSet;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class DbLoader extends DbLoaderBase implements ApplicationRunner
{
    private ScopeDao scopes;
    private ReportDao reports;
    private TagDao tags;
    private UserTagDao userTags;
    private SimulationDao simulations;

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
        super(roleDao, templateDao, permissionDao, newsArticleDao, userDao);

        this.scopes = scopeDao;
        this.reports = reportDao;
        this.tags = tagDao;
        this.userTags = userTagDao;
        this.simulations = simulationDao;
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
            this.addTemplatesToScopes(level2Analysis);
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

    private void addReportsToScopes(List<Scope> scopes, int nrOfReports)
    {
        for (Scope s : scopes)
        {
            this.addReportsToScope(s, nrOfReports);
        }
    }

    private void addTemplatesToScopes(List<Scope> scopes)
    {
        for (Scope s : scopes) {
            Iterator<Template> allTemplates = this.templates.findAll().iterator();
            Set<Template> templates = new HashSet<>();
            while (allTemplates.hasNext())
                templates.add(allTemplates.next());
            s.setTemplates(templates);
            this.scopes.save(s);
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
        List<Scope> created;

        if (type == ScopeType.OFFICIAL)
        {
            String[] words = {"Analyst Meeting", "Closure SCR", "ORSA Reports", "Convergence"};
            List<Scope> parents = this.scopes.findByType(type);
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
                Scope tempScope = this.createScope(type, parent, scopeName);
                createdScopes.add(tempScope);
                this.scopes.save(tempScope);
            }
        }
        return createdScopes;
    }

    @NotNull
    private Scope createScope(ScopeType type, Scope parent, String scopeName)
    {
        long parentScope = parent.getId();
        Scope tempScope = new Scope();
        CapitalUser owner = this.users.findOne("admin");
        CapitalUser user1 = this.users.findOne("alessio");
        Set<CapitalUser> users = new HashSet<>();
        users.add(owner);
        users.add(user1);
        tempScope.setOwner(owner);
        tempScope.setUsers(users);
        tempScope.setName(scopeName);
        tempScope.setType(type);
        tempScope.setParent(parentScope);
        tempScope.setPublished(true);
        return tempScope;
    }

}