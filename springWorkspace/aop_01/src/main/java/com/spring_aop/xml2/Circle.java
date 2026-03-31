package com.spring_aop.xml2;

public class Circle {
	private int radius;
	
	public float width() {
		return 3.14f * radius * radius;
	}
	
	public float length() {
		return 2 * 3.14f * radius;
	}
	
	public void show() {
		System.out.println("면적: " + width() + ", 둘레: " + length());
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
