package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.MyUserDetailsService;


@Configuration
public class SecurityConfig {
	
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new MyUserDetailsService();
	    }
	 
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeRequests()
		 .requestMatchers(HttpMethod.GET,"/trainers/list").authenticated()
		 .requestMatchers(HttpMethod.POST,"/trainers/add/courses/**").authenticated()

		 
			//.requestMatchers(HttpMethod.GET,"").permitAll()
//			.requestMatchers(HttpMethod.GET,"/api/user/**").permitAll()
//			.requestMatchers(HttpMethod.PUT,"/api/user/**").authenticated()
//
		 
		 .and() 
			.httpBasic()
			.and().csrf().disable()
			.cors().disable();
			http.authenticationProvider(authenticationProvider());
		 	return http.build();
	 }
	     
	    @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	    	return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
	         
	    }
	    @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authConfig) throws Exception {
	        return authConfig.getAuthenticationManager();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	         
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	     
	        return authProvider;
	    }


}