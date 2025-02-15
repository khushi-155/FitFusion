package com.CN.FitFusion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.CN.FitFusion.jwt.JwtAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class FitFusionSecurityConfig {
    
	@Autowired
	JwtAuthenticationFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/user/register","/auth/login").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	
		
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
		
	}
}
