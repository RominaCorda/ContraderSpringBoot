package it.com.ibm.generali.capitalreporting.config;

import it.com.ibm.generali.capitalreporting.CapitalReportingApplication;
import it.com.ibm.generali.capitalreporting.framework.BasePathAwareRelativePathProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger is a simple yet powerful representation of your RESTful API.
 *
 * @see <a href="http://swagger.io">swagger doc</a>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    @Value("${swagger.base-path}")
    private String basePath;

    /**
     * @return Docket
     * @see <a href="http://swagger.io">swagger doc</a>
     */
    @Bean
    public Docket api()
    {
        final String version = CapitalReportingApplication.getVersion();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("it.com.ibm.generali.capitalreporting.controller.rest"))
                .paths(PathSelectors.any())
                .build()
                .pathProvider(new BasePathAwareRelativePathProvider(basePath))
                .apiInfo(apiInfo(version));

    }


    private ApiInfo apiInfo(String version)
    {
        Contact contact = new Contact("IBM GBS iX", "http://www.ibm.com/it-it/",
                "support_ix@it.ibm.com");

        return new ApiInfo(
                "IBM Generali CapitalReporting API",
                "CapitalReporting Services.",
                version,
                "Terms of service",
                "IBM GBS iX",
                "License of API",
                "http://www.ibm.com/it-it/");
    }

}
