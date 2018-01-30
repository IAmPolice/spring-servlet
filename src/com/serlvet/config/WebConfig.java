package com.serlvet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.serlvet.controller")
// @ImportResource({"file:**/WEB-INF/flows/flows-config.xml"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter() {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        return filter;
//    }
//
//    public StandardServletMultipartResolver resolver() {  
//        return new StandardServletMultipartResolver();  
//    }

    // @Bean
    // public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
    // ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    // viewResolver.setTemplateEngine(templateEngine);
    // return viewResolver;
    // }

    // @Bean
    // public TemplateEngine templateEngine(TemplateResolver templateResolver){
    // SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    // templateEngine.setTemplateResolver(templateResolver);
    // return templateEngine;
    // }
    //
    // @Bean
    // public TemplateResolver templateResolver() {
    // TemplateResolver templateResolver = new ServletContextTemplateResolver();
    // templateResolver.setPrefix("/WEB-INF/views/");
    // templateResolver.setSuffix(".html");
    // templateResolver.setTemplateMode("HTML5");
    // return templateResolver;
    // }

    /**
    * 默認交給serlvet讀取靜態資料
    *
    *                        ***********     ********************
    *                        * servlet * --> * static resources *
    *                        ***********     ********************
    *                             ^
    *                             |  (configureDefaultServletHandling method config)
    *                             |
    *                       **************
    *   [http request]  ->  * dispatcher *
    *   [http response] <-  *  servlet   *
    *                       **************
    */
    // @Override
    // public void configureDefaultServletHandling(DefaultServletHandlerConfigurer
    // configurer) {
    // configurer.enable();
    // }
    //

    /**
    * 在spring mvc的dispatcher servlet加入靜態資料
    *
    *                       **************    ************
    *   [http request]  ->  * dispatcher *    *   Path   *    ********************
    *   [http response] <-  *            * -> * Resource * -> * static resources *
    *                       *  servlet   *    * Resolver *    ********************
    *                       **************    ************
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

}
