package com.spring_boot_book.project;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/book_images/**").
		addResourceLocations("file:///Users/lsh/Documents/hyundai_bootcamp_course/springbootWorkspace/book_images/");
	}
}
