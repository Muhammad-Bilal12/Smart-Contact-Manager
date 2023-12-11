package com.smart.smart_contact_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig {

    // @Bean
    // UserDetailsService getUserDetailsService() {
    // return new UserDetailsServicesImpl();
    // }

    // @Bean
    // BCryptPasswordEncoder getPasswordEncoder() {
    // return new BCryptPasswordEncoder();
    // }

    // public DaoAuthenticationProvider authenticationProvider() {
    // DaoAuthenticationProvider daoAuthenticationProvider = new
    // DaoAuthenticationProvider();

    // daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
    // daoAuthenticationProvider.setPasswordEncoder(this.getPasswordEncoder());

    // return daoAuthenticationProvider;

    // }

    // Newer version

}
