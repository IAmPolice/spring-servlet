package com.serlvet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
@ComponentScan("com.serlvet.controller")
//@ImportResource({"file:**/WEB-INF/flows/flows-config.xml"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private WebFlowConfig webFlowConfig;

    @Bean
    public ViewResolver viewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
    }
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//      viewResolver.setTemplateEngine(templateEngine);
//      return viewResolver;
//    }

//    @Bean 
//    public TemplateEngine templateEngine(TemplateResolver templateResolver){
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine;
//    }
//
//    @Bean
//    public TemplateResolver templateResolver() {
//      TemplateResolver templateResolver = new ServletContextTemplateResolver();
//      templateResolver.setPrefix("/WEB-INF/views/");
//      templateResolver.setSuffix(".html");
//      templateResolver.setTemplateMode("HTML5");
//      return templateResolver;
//    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/login").setViewName("login");
//    }

    /** =========== Spring Webflow Config Start=========== **/
    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
        handlerMapping.setOrder(-1);
        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
        return handlerMapping;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdapter;
    }

    // Config Spring Weflow of web page location in serlvet.
    @Bean
    public ViewResolver flowViewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/flows/order/");
      resolver.setSuffix(".jsp");
      return resolver;
    }
    /** =========== Spring Webflow Config End=========== **/
}
