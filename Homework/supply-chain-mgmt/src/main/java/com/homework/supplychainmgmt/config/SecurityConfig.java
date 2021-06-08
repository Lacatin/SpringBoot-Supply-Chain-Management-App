package com.homework.supplychainmgmt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.GET, "/orders").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/users/{userId}").hasRole("CLIENT")
                .mvcMatchers(HttpMethod.DELETE, "/orders/{orderId}").hasRole("CLIENT")
                .mvcMatchers(HttpMethod.DELETE, "/orders/myorders").hasRole("CLIENT")
                .mvcMatchers(HttpMethod.DELETE, "/orders/ordersforme").hasRole("MANUFACTURER")
                .mvcMatchers(HttpMethod.GET, "/items").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.GET, "/orderitems").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/orderitems").hasRole("CLIENT")
                .anyRequest().authenticated();
    }


    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

}
