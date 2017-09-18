package com.serlvet.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?> []{ SecurityConfig.class, MongoConfig.class }; 
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class, WebFlowConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

//    protected WebApplicationContext createServletApplicationContext() {
//        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/WEB-INF/flows/config.xml");
//        return (WebApplicationContext) context;
//        
//    }
}
