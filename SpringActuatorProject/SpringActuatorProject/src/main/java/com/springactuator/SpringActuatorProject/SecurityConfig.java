package com.springactuator.SpringActuatorProject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/actuator/**").permitAll()  // Allow access to all actuator endpoints
                        .requestMatchers("/users/add").permitAll()  // Allow access to POST /users/add
                        .anyRequest().authenticated()  // Require authentication for other requests
                )
                .csrf(csrf -> csrf.disable())  // Disable CSRF if needed
                .httpBasic(httpBasicCustomizer -> {});  // Updated way to configure HTTP Basic

        return http.build();
    }
}


