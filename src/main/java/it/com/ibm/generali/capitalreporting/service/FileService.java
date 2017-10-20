package it.com.ibm.generali.capitalreporting.service;

public class FileService {

    public boolean checkExtension(String reportFile)
    {
        int dot = reportFile.lastIndexOf('.');
        String ext = (dot == -1) ? "" : reportFile.substring(dot+1);

        return (ext.equals("zip")) ? true : false;
    }

}