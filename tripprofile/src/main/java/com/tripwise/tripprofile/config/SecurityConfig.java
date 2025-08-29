package com.tripwise.tripprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@Profile("dev")  // valid only in dev profile
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)                      // CSRF disabled
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())  // ALL endpoints are free
                .httpBasic(AbstractHttpConfigurer::disable)                 // Basic Auth disabled
                .formLogin(AbstractHttpConfigurer::disable)                 // Form login disabled
                .logout(AbstractHttpConfigurer::disable)                    // Logout disabled
                .build();
    }
}
