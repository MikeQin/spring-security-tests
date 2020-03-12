package com.example.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/get").permitAll()
		.anyRequest().authenticated().and()
		.httpBasic()
		.and()
		.formLogin().loginPage("/login").permitAll().and()
		.logout().permitAll()
		.and()
		.csrf().disable(); // allow post without sync token
	}

	/**
	 * User database for authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password(passwordEncoder().encode("123")).roles("USER").and()
		.withUser("amazefoto").password(passwordEncoder().encode("amazefoto")).roles("USER").and()
		.withUser("mike").password(passwordEncoder().encode("123")).roles("ADMIN", "USER");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}