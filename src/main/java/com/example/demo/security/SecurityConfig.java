package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Role;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	//Building JDBC based authentication
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//csrf is disabled
		httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole(Role.ADMIN)
				//Authorize the admin
		        .antMatchers(HttpMethod.POST).hasRole(Role.ADMIN)
		        .antMatchers(HttpMethod.POST, "/user/**","/signup/**").permitAll()
				.antMatchers(HttpMethod.PUT).hasRole(Role.ADMIN)
				.antMatchers("/customer/**", "/planters/**", "/plant/**", "/seed/**")
				.hasAnyRole(Role.ADMIN, Role.USER).and().authorizeRequests().anyRequest().permitAll().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic();

	}

	// BCRYPT PASSWORD ENCODER
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}