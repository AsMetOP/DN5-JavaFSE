package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		AuthenticationManagerBuilder auth = null;
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(org.springframework.security.core.userdetails.User
				.withUsername("admin")
				.password(passwordEncoder.encode("pwd"))
				.roles("ADMIN")
				.build());
		manager.createUser(org.springframework.security.core.userdetails.User
				.withUsername("user")
				.password(passwordEncoder.encode("pwd"))
				.roles("USER")
				.build());
		return manager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf(csrf -> csrf.disable())
			.httpBasic(basic -> {})
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/countries").hasRole("USER")
				.anyRequest().authenticated()
			);
		return httpSecurity.build();
	}

}