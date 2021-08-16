package com.jyoti.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
	
	/**
	 * @return PasswordEncoder
	 * which is an interface. It contains a method 
	 * String encode(CharSequence rawPassword);
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		//BCryptPasswordEncoder is most famous password encoder
		return new BCryptPasswordEncoder(10);//10 is the strength of encode
	}

}
