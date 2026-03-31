package com.spring_aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");

		// 핵심 기능 1
		Rect rect = context.getBean("rect", Rect.class);
		Gugudan gg = context.getBean("gugudan", Gugudan.class);
		
		// 핵심 기능 1 호출
		// rect.showResult();
		gg.showResult();
	}

}
