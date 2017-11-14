package it.com.ibm.generali.capitalreporting.service;

import it.com.ibm.generali.capitalreporting.dao.RoleDao;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import it.com.ibm.generali.capitalreporting.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FileUploaderService
{

    private Logger logger = LoggerFactory.getLogger(FileUploaderService.class);

    private UserDao users;
    private RoleDao roles;

    public FileUploaderService(UserDao userDao, RoleDao roles)
    {
        this.users = userDao;
        this.roles = roles;
    }

    public boolean uploadFile(MultipartFile file)
    {
        BufferedReader br = null;
        String line;

        boolean uploadedOk = true;
        List<CapitalUser> utenti = new ArrayList<>();

        try
        {
            br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((line = br.readLine()) != null)
            {
                if (line.length() > 1)
                {
                    String[] data = line.split(";");
                    if (data.length != 5)
                    {
                        logger.error("Unknown CSV data format for users. Expected 5 fields, found " + data.length);
                    }
                    else
                    {
                        utenti.add(this.buildUser(data));
                    }
                }
            }
            this.users.save(utenti);
        }
        catch (Exception e)
        {
            uploadedOk = false;
            logger.error(e.getMessage());
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    uploadedOk = false;
                    logger.error(e.getMessage());
                }
            }
        }

        return uploadedOk;

    }

    private CapitalUser buildUser(String[] data)
    {
        CapitalUser user = this.users.findOne(data[0]);
        if (user != null)
        {
            logger.info(" -- Modifying user " + user.getUsername());
            user.setPassword(data[1]);
            user.setFullName(data[2]);
            user.setEmail(data[3]);
            Set<Role> roles = new HashSet<>();
            roles.add(this.roles.findByDescription(data[4]));
            user.setRoles(roles);
        }
        else
        {
            logger.info(" -- Adding user " + data[0]);
            Role role = this.roles.findByDescription(data[4]);
            if (role != null)
            {
                user = new CapitalUser(data[0], data[1], data[2], data[3], role);
            }
            else
            {
                logger.warn("Cannot add user: role not found.");
            }
        }
        return user;
    }
}
