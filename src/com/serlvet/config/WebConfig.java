package com.serlvet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
//@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
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

}
