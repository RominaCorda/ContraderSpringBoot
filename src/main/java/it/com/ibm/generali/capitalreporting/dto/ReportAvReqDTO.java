package it.com.ibm.generali.capitalreporting.dto;

public class ReportAvReqDTO
{
    private String environmentID;
    private String reportID;
    private String reportFile;

    public String getEnvironmentID()
    {
        return environmentID;
    }

    public void setEnvironmentID(String environmentID)
    {
        this.environmentID = environmentID;
    }


    public String getReportID()
    {
        return reportID;
    }

    public void setReportID(String reportID)
    {
        this.reportID = reportID;
    }


    public String getReportFile()
    {
        return reportFile;
    }

    public void setReportFile(String reportFile)
    {
        this.reportFile = reportFile;
    }

}