package com.shivam._4.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean // Spring will make the object even if you don't
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        security.csrf(customizer -> customizer.disable()); // Disable CSRF
        // Enable security for all requests
        security.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        security.httpBasic(Customizer.withDefaults());
        // Make it stateless
        security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return security.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.withDefaultPasswordEncoder().username("Shivam").password("1234").roles("USER").build();

        UserDetails admin = User.withDefaultPasswordEncoder().username("Kiran").password("1234").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
