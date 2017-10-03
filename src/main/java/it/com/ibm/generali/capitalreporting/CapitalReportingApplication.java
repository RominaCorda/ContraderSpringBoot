package it.com.ibm.generali.capitalreporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CapitalReportingApplication
        extends SpringBootServletInitializer
{

    public static final String APP_TITLE = "CAPITAL REPORTING";

    private static Logger logger = LoggerFactory.getLogger(CapitalReportingApplication.class);

    /**
     * Version. It must be the same as that found in gradle.properties
     */
    private static final String version = "0.2.5";

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

    /**
     * When used as a WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        hello();
        return builder.sources(CapitalReportingApplication.class);
    }

}
