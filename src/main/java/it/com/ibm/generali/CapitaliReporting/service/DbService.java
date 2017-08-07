package it.com.ibm.generali.CapitaliReporting.service;


import it.com.ibm.generali.CapitaliReporting.dao.UserDao;
import it.com.ibm.generali.CapitaliReporting.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService
{
    private Logger logger = LoggerFactory.getLogger(DbService.class);

    private UserDao userDao;

    @Autowired
    public DbService(UserDao dbUserDao)
    {
        this.userDao = dbUserDao;
    }

    public void initializeUsersDb()
    {
        this.logger.info("Initializing user database...");

        User admin = new User("admin", "pass");
        User alessio = new User("alessio", "doctor");

        this.userDao.save(admin);
        this.userDao.save(alessio);

        this.logger.info("Initializing user database done.");
    }

}
