package com.jyoti.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http// from the parameter
				.authorizeRequests()
				// white-listing few resources and permitting them
				.antMatchers("/", "index", "/css/*", "/js/*", "/api/v1/students/1").permitAll().anyRequest()//
				.authenticated()// as user must enter username and password
				.and()//
				.httpBasic();// As wants to use "basic authentication"
	}

	/*
	 * A method to create an user 
	 * UserDetailsService 
	 * is how you retrieve user from DB
	 */
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails jyotiUser = User.builder().username("jyoti")// user name
				.password(passwordEncoder.encode("password"))// encoded password
				.roles("student").build();// assigned a role
		return new InMemoryUserDetailsManager(jyotiUser);
	}

}
