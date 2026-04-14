package com.spring_boot.projectEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 스프링 시큐리티 기능 중 사용할 것과 하지 않을 것을 설정
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	// 비밀번호 암호화에 사용할 암호화 알고리즘 객체
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 스프링 시큐리가 추가되면 동작하는 기본 기능들에 대해 설정을 진행(사용여부, 초기화 등)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf->csrf.disable())
			.formLogin(formLogin->formLogin.disable())
			.headers(headerConfig->
						headerConfig.frameOptions(frameOptionConfig->frameOptionConfig.disable()));
		return http.build(); // 바뀐 보안 설을 http에 반영하고 SecurityFilterChain 타입의 객체 반환
	}
}
