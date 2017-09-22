package it.com.ibm.generali.CapitalReporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapitalReportingApplication
{

    public static final String APP_TITLE = "ANNA REPORTING";

    private static Logger logger = LoggerFactory.getLogger(CapitalReportingApplication.class);

    /**
     * Version. It must be the same as that found in gradle.properties
     */
    private static final String version = "0.2.0";

    /**
     * Get the application's version.
     *
     * @return the application's version
     */
    public static String getVersion()
    {
        return CapitalReportingApplication.version;
    }

    public static void main(String[] args)
    {
        hello();
        SpringApplication.run(CapitalReportingApplication.class, args);
    }

    private static void hello()
    {
        logger.info("**********************************************");
        logger.info("  Generali Capital Reporting App v." + version);
        logger.info("**********************************************");
    }

}
