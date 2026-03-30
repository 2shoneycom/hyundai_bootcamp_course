package com.di.spring_di_xml_setter;

public class NameController {
	NameService nameService;
	
	// 생성자가 다른 전달받을 내용이 많을때는 setter를 활용해 주입 받기
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("Name Controller: " + nameService.showName(name));
	}
}
