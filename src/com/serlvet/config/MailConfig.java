package com.serlvet.config;

import java.security.Security;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = { "com.serlvet.lib" })
public class MailConfig {

    @Bean
    public JavaMailSenderImpl mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // mailSender.setHost("smtp.gmail.com");
        mailSender.setHost("mail.acesolution.com.tw");
        mailSender.setPort(587);
        // mailSender.setPort(465);
        // mailSender.setUsername("style80964@gmail.com");
        // mailSender.setPassword("slowly837795");
        // mailSender.setUsername("stone_shih@gemteks.com");
        // mailSender.setPassword("slowly837795");
        mailSender.setUsername("nancy_dai@acesolution.com.tw");
        mailSender.setPassword("pianosmarter");

        // Get a Properties object
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        // props.setProperty("mail.smtp.socketFactory.class",
        // "javax.net.ssl.SSLSocketFactory");
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
