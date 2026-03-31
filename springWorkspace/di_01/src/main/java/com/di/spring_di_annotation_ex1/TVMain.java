package com.di.spring_di_annotation_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config4.xml");
		TV tv = context.getBean("tv", TV.class);
		tv.volumeUp();
		tv.volumeDown();
	}

}
