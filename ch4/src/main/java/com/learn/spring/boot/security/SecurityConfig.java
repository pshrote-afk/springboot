package com.learn.spring.boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration      // signals that this class is a source of bean definitions rather than actual application code
public class SecurityConfig
{
    @Bean
    public UserDetailsService UserDetailsService()  // if this implementation is missing, then default user is created
    {
        /*
        UserDetailsService is an interface
        InMemoryUserDetailsManager implements it
        We return that object
        So Spring sees: “Aha! I have a UserDetailsService bean”
        */

        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();           // UserDetailsManager supports CRUD of users
        userDetailsManager.createUser(User.withDefaultPasswordEncoder().username("user").password("pass").roles("USER").build());
        userDetailsManager.createUser(User.withDefaultPasswordEncoder().username("admin").password("pass").roles("ADMIN").build());
        return userDetailsManager;
    }
}