package it.com.ibm.generali.CapitalReporting.framework;

import springfox.documentation.spring.web.paths.AbstractPathProvider;

/**
 * Used by Swagger Config
 */
public class BasePathAwareRelativePathProvider extends AbstractPathProvider
{
    private String basePath;

    public BasePathAwareRelativePathProvider(String basePath)
    {
        this.basePath = basePath;
    }

    @Override
    protected String applicationPath()
    {
        return basePath;
    }

    @Override
    protected String getDocumentationPath()
    {
        return "/";
    }

    @Override
    public String getOperationPath(String operationPath)
    {
        return operationPath;
    }

}
