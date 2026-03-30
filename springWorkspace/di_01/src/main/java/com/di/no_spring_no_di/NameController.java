package com.di.no_spring_no_di;

public class NameController {
	// 필요한 곳에서 new 연산자를 사용해서 객체 직접 생성
	// NameController 클래스는 NameService 클래스와 강한 의존 관계가 있는 상태
	NameService nameService = new NameService();
	
	public void show(String name) {
		System.out.println("Name Controller: " + nameService.showName(name));
	}
}
