package it.com.ibm.generali.capitalreporting.service;

import org.springframework.stereotype.Service;

@Service
public class ReportAvailability {

    public String reportFound(String environmentID, String reportID, String reportFile) {
        String response = "";
        response = environmentID + "_" + reportID + "_" + reportFile;

        return response;
    }

}