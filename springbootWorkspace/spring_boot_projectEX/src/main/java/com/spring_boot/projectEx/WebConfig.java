package com.spring_boot.projectEx;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/prd_images/**")
			.addResourceLocations("file:///Users/lsh/Documents/hyundai_bootcamp_course/springbootWorkspace/product_images/");
	}
}
