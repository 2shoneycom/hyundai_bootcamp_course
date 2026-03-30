package com.di.no_spring_di_constructor;

public class NameMain {
	public static void main(String[] args) {
		NameService nameService = new NameService();
		NameController controller = new NameController(nameService);
		controller.show("홍길동");
	}
}
