package it.com.ibm.generali.CapitaliReporting.service;


import it.com.ibm.generali.CapitaliReporting.config.Users;
import it.com.ibm.generali.CapitaliReporting.dao.UserDao;
import it.com.ibm.generali.CapitaliReporting.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

        HashMap<String, String> users = Users.INSTANCE.getGet();

        for (Map.Entry<String, String> user : users.entrySet())
        {
            String username = user.getKey();
            String password = user.getValue();
            this.logger.info("... adding user " + username);
            User tmpUser = new User(username, password);
            this.userDao.save(tmpUser);
        }


        this.logger.info("Initializing user database done.");
    }

}
