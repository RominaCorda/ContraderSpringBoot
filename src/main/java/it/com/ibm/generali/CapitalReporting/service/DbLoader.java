package it.com.ibm.generali.CapitalReporting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DbLoader implements ApplicationRunner
{

    private DbService dbService;

    @Autowired
    public DbLoader(DbService dbService)
    {
        this.dbService = dbService;
    }

    public void run(ApplicationArguments args)
    {
        //
    }
}