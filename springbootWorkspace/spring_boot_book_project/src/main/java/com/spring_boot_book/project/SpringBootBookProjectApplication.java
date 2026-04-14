package com.spring_boot_book.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.spring_boot_book.project"})
@MapperScan(basePackages={"com.spring_boot_book.project"})
public class SpringBootBookProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookProjectApplication.class, args);
	}

}
