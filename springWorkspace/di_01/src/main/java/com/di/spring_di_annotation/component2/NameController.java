package com.di.spring_di_annotation.component2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameController {
	@Autowired
	NameService nameService;
	
	public void show(String name) {
		System.out.println("Name Controller: " + nameService.showName(name));
	}
}
