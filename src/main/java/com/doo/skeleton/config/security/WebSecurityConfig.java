package com.doo.skeleton.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin();
		
		return http.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
    	// return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
	
	/**
	 * UserDetailsService의 구현class가 없을 때 @Bean등록 후 사용
	 * @return
	 */
	// @Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("admin")
				.password("{noop}admin")
				.roles("USER","ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
