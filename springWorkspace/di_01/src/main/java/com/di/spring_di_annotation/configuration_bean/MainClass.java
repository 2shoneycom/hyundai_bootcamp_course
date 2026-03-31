package com.di.spring_di_annotation.configuration_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 스프링 컨테이너 생성
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Member member = context.getBean("member", Member.class);
		
		System.out.println(member);
		member.showBmi();
		
	}

}
