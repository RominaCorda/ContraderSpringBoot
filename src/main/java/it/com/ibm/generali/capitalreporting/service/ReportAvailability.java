package it.com.ibm.generali.capitalreporting.service;

import org.springframework.stereotype.Service;


@Service
public class ReportAvailability
{
    public String reportFound(String environmentID, String reportID, String reportFile)
    {
        // Check reportFile extension
        FileService fileService = new FileService();
        boolean checkExtensionBool = fileService.checkExtension(reportFile);

        /*
         * Temporary implementation
         */
        String X = (checkExtensionBool) ? "ZIPFILE" : "OTHERFILE";

        return X + "_" + environmentID + "_" + reportID + "_" + reportFile;
    }


}