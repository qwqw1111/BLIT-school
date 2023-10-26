package com.binarySchool.school.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain handler(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.mvcMatchers(HttpMethod.GET, "/api/v1/student/students")
				.hasAnyRole("STUDENT","TEACHER","ADMIN")
				
				.mvcMatchers(HttpMethod.POST, "/api/v1/student")
				.hasAnyRole("STUDENT","ADMIN")
				
				.mvcMatchers(HttpMethod.POST, "/api/v1/course")
				.hasAnyRole("TEACHER","ADMIN")
				
				.mvcMatchers(HttpMethod.POST, "/api/v1/teacher")
				.hasAnyRole("TEACHER","ADMIN")
				
				.mvcMatchers(HttpMethod.PUT, "/api/v1/teacher/id/{id}")
				.hasAnyRole("ADMIN")
				
				.mvcMatchers(HttpMethod.PUT, "/api/v1/student/id/{id}")
				.hasAnyRole("ADMIN")
				
				.mvcMatchers(HttpMethod.PUT, "/api/v1/course/id/{id}")
				.hasAnyRole("TEACHER","ADMIN")
				
				.mvcMatchers(HttpMethod.DELETE, "/api/v1/teacher/id/{id}")
				.hasAnyRole("ADMIN")
				
				.mvcMatchers(HttpMethod.DELETE, "/api/v1/student/id/{id}")
				.hasAnyRole("ADMIN")
				
				.mvcMatchers(HttpMethod.DELETE, "/api/v1/course/id/{id}")
				.hasAnyRole("TEACHER","ADMIN")
				
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().httpBasic()
				.and().build();
	}
	
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails student = User.builder().username("student").password(bCryptPasswordEncoder().encode("sPass")).roles("STUDENT").build();
		UserDetails teacher = User.builder().username("teacher").password(bCryptPasswordEncoder().encode("tPass")).roles("TEACHER").build();
		UserDetails admin = User.builder().username("sysadmin").password(bCryptPasswordEncoder().encode("password")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(student, teacher, admin);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
