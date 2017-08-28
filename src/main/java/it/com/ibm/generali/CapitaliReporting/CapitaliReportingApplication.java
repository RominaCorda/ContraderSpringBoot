package it.com.ibm.generali.CapitaliReporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapitaliReportingApplication
{

    private static Logger logger = LoggerFactory.getLogger(CapitaliReportingApplication.class);

    /**
     * Version. It must be the same as that found in gradle.properties
     */
    private static final String version = "0.1.1";

    /**
     * Get the application's version.
     *
     * @return the application's version
     */
    public static String getVersion()
    {
        return CapitaliReportingApplication.version;
    }

    public static void main(String[] args)
    {
        hello();
        SpringApplication.run(CapitaliReportingApplication.class, args);
    }

    private static void hello()
    {
        logger.info("**********************************************");
        logger.info("  Generali Capitali Reporting App v." + version);
        logger.info("**********************************************");
    }

}
