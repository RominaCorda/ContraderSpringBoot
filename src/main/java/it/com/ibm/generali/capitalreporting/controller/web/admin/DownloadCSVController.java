package it.com.ibm.generali.capitalreporting.controller.web.admin;

import it.com.ibm.generali.capitalreporting.controller.web.SessionHelper;
import it.com.ibm.generali.capitalreporting.dao.UserDao;
import it.com.ibm.generali.capitalreporting.model.CapitalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DownloadCSVController extends SessionHelper
{
    private Logger logger = LoggerFactory.getLogger(DownloadCSVController.class);
    private UserDao users;

    @Autowired
    public DownloadCSVController(UserDao userDao)
    {
        this.users = userDao;
    }


    @RequestMapping(value = "/userscsvdownload")
    public String downloadCSV(HttpSession session, HttpServletResponse response)
    {
        logger.info("/userscsvdownload page");

        if (!this.isAdmin(session))
        {
            return "redirect:login";
        }

        String csvFileName = "users.csv";

        response.setContentType("text/csv");

        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);

        try
        {
            PrintWriter writer = response.getWriter();
            CsvMapWriter csvWriter = new CsvMapWriter(writer, CsvPreference.STANDARD_PREFERENCE);

            final String[] header = new String[]{"Username", "Full Name", "eMail", "active"};

            csvWriter.writeHeader(header);

            for (CapitalUser user : this.users.findAll())
            {
                final Map<String, Object> usermap = new HashMap<>();
                usermap.put(header[0], user.getUsername());
                usermap.put(header[1], user.getFullName());
                usermap.put(header[2], user.getEmail());
                usermap.put(header[3], user.getActive());
                csvWriter.write(usermap, header);
            }

            csvWriter.close();
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }

        return "";

    }
}

