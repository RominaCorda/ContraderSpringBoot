package it.com.ibm.generali.capitalreporting.service;


import it.com.ibm.generali.capitalreporting.dao.UserDao;
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

}
