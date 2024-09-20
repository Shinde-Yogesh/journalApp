package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.practice.service.UserDetailsServiceImpl;


@Component
@EnableWebSecurity
class SpringSecurity {
	
	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;


	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


	        return http.authorizeHttpRequests(request -> request
//                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/journal/**").authenticated()
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().permitAll())
                    .csrf(AbstractHttpConfigurer::disable)
                    .build();
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
