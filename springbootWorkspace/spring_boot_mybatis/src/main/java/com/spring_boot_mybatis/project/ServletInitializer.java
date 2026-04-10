package com.spring_boot_mybatis.project;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 스프링 부트 애플리케이션을 web.xml 없이 톰캣에서 실행가능하도록 설정을 진행(구성)함
// context 관련한 설정 진행
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMybatisApplication.class);
	}

}
