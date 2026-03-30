package com.di.spring_di_xml_constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
	public static void main(String[] args) {
		// 설정 파일 (application-context.xml)을 스프링 컨테이너에게 전달
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-context.xml");
		
		// 스프링 컨테이너가 설정파일을 해석해서 bean(객체 인스턴스)을 준비
		// 필요한 객체는 context의 getBean() 메소드 통해 객체 익스턴스 할당
		NameController controller = context.getBean("nameController", NameController.class);
		controller.show("홍길동");
	}
}
