package com.spring_boot_fileupload.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot_fileupload.mybatis"})
@MapperScan(basePackages= {"com.spring_boot_fileupload.mybatis"})
public class SpringBootFileuploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileuploadApplication.class, args);
	}

}
