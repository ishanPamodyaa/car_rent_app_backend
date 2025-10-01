package edu.icet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurity {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    httpSecurity.
            authorizeHttpRequests(request -> request
                    .requestMatchers("/api/admin/**").permitAll()
                    .anyRequest().authenticated())
                        .csrf( csrf -> csrf.disable())
                            .httpBasic();
    return httpSecurity.build();
  }

}
