package com.serlvet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.serlvet.db.mongo.UserService;
import com.serlvet.db.mongo.repository.UserRepository;

@Configuration
@EnableWebMvcSecurity
//@EnableSpringConfigured
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/login").formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(new UserService());
        auth.userDetailsService(new UserService(userRepository));
    }
}
