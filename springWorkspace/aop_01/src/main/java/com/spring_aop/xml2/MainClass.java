package com.spring_aop.xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config2.xml");

		// 핵심 기능 1
		Evaluation eval = context.getBean("eval", Evaluation.class);
		Circle circle = context.getBean("circle", Circle.class);
		
		// 핵심 기능 1 호출
		eval.show();
		circle.show();
	}

}
