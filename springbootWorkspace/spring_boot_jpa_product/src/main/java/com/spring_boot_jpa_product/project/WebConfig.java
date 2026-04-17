package com.spring_boot_jpa_product.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// /prd_images/**/ <-> 저장한 이미지 폴더의 실제 경로
		registry.addResourceHandler("/prd_images/**").addResourceLocations("file:////Users/lsh/Documents/hyundai_bootcamp_course/springbootWorkspace/product_images/");
	}
}
