package com.jcmn.restAPITest.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // All request must be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        //  Basic authentication pop-up
        http.httpBasic(withDefaults());

        // CSRF -> POST, PUT
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
