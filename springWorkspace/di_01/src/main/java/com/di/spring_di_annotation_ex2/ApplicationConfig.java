package com.di.spring_di_annotation_ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.di.spring_di_annotation_ex2")
@Configuration
public class ApplicationConfig {
	@Bean
	public TV tv() {
		TV tv = new TV();
		tv.setSpeaker(new Speaker());
		return tv;
	}
}
