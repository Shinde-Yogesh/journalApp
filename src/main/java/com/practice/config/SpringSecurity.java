package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.practice.service.UserDetailsServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;


@Component
@EnableWebSecurity
class SpringSecurity {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(request -> request
//
//                        .requestMatchers("/journal/**").authenticated() // while comment both program run for get all user call
//                        .requestMatchers("/user/**").authenticated()
//                        .anyRequest().permitAll())
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Define authorization rules
        http.authorizeHttpRequests(authz -> authz
                        .requestMatchers("/journal/**", "/user/**").authenticated() // Secure these paths
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Secure these paths
                        .anyRequest().permitAll() // Allow all other paths
                )
                // Enable basic authentication
                .httpBasic(withDefaults())
                // Set session management to stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Disable CSRF (for APIs, stateless sessions, etc.)
                .csrf(csrf -> csrf.disable());

        return http.build(); // Return the configured SecurityFilterChain
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
