package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.employee.service.UserInfoUserDetailsService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/swagger-ui/**","/v3/api-docs").hasAnyRole("USER") 
                        .requestMatchers(HttpMethod.GET, "/employees").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.GET, "/employees/{employeeId}").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.GET, "/employees/personal/{employeeId}").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.POST, "/employees").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/employees//update").hasAnyRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/employees/{employeeId}").hasRole("USER")
                        .anyRequest().authenticated()
        );
        http.httpBasic();
        http.csrf().disable(); 
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}