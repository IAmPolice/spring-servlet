package com.serlvet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.serlvet.db.mongo.UserService;
import com.serlvet.db.mongo.repository.UserRepository;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.serlvet.db.mongo"}, basePackageClasses = UserService.class )
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/register", "/error").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
