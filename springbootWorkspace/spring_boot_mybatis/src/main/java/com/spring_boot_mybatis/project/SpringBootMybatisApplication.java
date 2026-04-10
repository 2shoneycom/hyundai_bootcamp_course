package com.spring_boot_mybatis.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//클래스를 스프링부트 app으로 구성해주는 모듈
@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot_mybatis.project"})
@MapperScan(basePackages= {"com.spring_boot_mybatis.project"})
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
