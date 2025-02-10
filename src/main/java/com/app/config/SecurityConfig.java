package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	public SecurityConfig() {
		System.out.println("SecurityConfig called here");
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService()
	{
		UserDetails admin = User.builder().username("Swami").password(passwordEncoder().encode("Ganu")).roles("ADMIN").build();
		
		UserDetails users = User.builder().username("Shiv").password(passwordEncoder().encode("balaji")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin,users);
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf(customer->customer.disable())
				//.cors(Customizer.withDefaults())
				.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.GET).hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST).hasRole("USER")
						.requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE).hasRole("USER")
						.anyRequest().authenticated()
						
						
						
						)
				.httpBasic(Customizer.withDefaults())
				.build();
				
				
	}

}
