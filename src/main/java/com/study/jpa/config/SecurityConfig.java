package com.study.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: 张远志
 * @Date: 2020/5/11 13:28
 */

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("UserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        /*auth
                .inMemoryAuthentication()
                // 管理员用户，只能访问 /customer/**
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .and()
                // 普通用户，只能访问 /order/**
                .withUser("user")
                .password("{noop}user")
                .roles("USER")
                .and()
                // 超级管理员，同时具有 ADMIN,USER权限，可以访问所有资源
                .withUser("yuanZhi")
                .password("{noop}123456")
                .roles("ADMIN","USER");*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
  /*      http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
        http
                .authorizeRequests()
                .antMatchers("/customer/**").hasRole("ADMIN")
                .antMatchers("/order/**").hasRole("USER")
//                .antMatchers("/**").hasRole("YUANZHI")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
