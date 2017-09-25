package it.com.ibm.generali.CapitalReporting.service;

import it.com.ibm.generali.CapitalReporting.dao.ScopeDao;
import it.com.ibm.generali.CapitalReporting.model.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DbLoader implements ApplicationRunner
{
    private Logger logger = LoggerFactory.getLogger(DbLoader.class);
    private ScopeDao scopes;
    final private Random seed = new Random();

    @Autowired
    public DbLoader(ScopeDao scopeDao)
    {
        this.scopes = scopeDao;
    }

    public void run(ApplicationArguments args)
    {
        logger.info("Loading initial scopes");

        // Level -1
        for (int year = 2012; year < 2018; year++)
        {
            Scope tempScope = new Scope();
            tempScope.setName(String.valueOf("YE" + String.valueOf(year)));
            tempScope.setParent(-1L);
            tempScope.setPublished(true);
            tempScope.setLevel(0);
            this.scopes.save(tempScope);
        }

        // Level 1
        List<String> scopeType = new ArrayList<>();
        scopeType.add("Analyst Meeting");
        scopeType.add("Closure SCR");
        scopeType.add("ORSA Reports");
        scopeType.add("Convergence");
        Iterable<Scope> nowScopes = this.scopes.findAll();
        for (Scope scope : nowScopes)
        {
            for (int j = 0; j < 4; j++)
            {
                Scope tempScope = new Scope();
                tempScope.setName(String.valueOf(scopeType.get(j)));
                tempScope.setParent(scope.getId());
                tempScope.setPublished(true);
                tempScope.setLevel(1);
                this.scopes.save(tempScope);
            }
        }

        // Level 2
        String[] words = {"Group", "Germany", "Italy", "Italy Solo",
                "France", "Czech Republic", "Spain", "Spain Solo", "United Kingdom",
                "Finland", "Sweden", "Romania", "Croatia"};
        Iterable<Scope> level1Scopes = this.scopes.findByLevel(1);
        for (Scope scope : level1Scopes)
        {
            int numberOfReports = seed.nextInt(10) + 2;
            for (int j = 0; j < numberOfReports; j++)
            {
                Scope tempScope = new Scope();
                tempScope.setName(words[seed.nextInt(words.length)]);
                tempScope.setParent(scope.getId());
                tempScope.setPublished(true);
                tempScope.setLevel(2);
                this.scopes.save(tempScope);
            }
        }

    }
}