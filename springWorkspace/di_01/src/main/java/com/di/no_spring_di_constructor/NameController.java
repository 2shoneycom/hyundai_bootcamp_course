package com.di.no_spring_di_constructor;

public class NameController {
	NameService nameService;
	// new 연산자로 객체 직접 생성하지 않고
	
	// 생성자를 통해서 NameService 객체 인스턴스를 전달(주입)받음
	// 의미: 생성자를 통해 외부에서 주입받음(Injection)
	public NameController(NameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("Name Controller: " + nameService.showName(name));
	}
}
