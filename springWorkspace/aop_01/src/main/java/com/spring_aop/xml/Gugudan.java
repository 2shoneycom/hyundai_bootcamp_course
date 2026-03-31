package com.spring_aop.xml;

// 핵심 기능
public class Gugudan {
	private int dan;
	
	public int getDan() {
		return dan;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void showResult() {
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d*%d=%d\n", dan, i, dan*i);
		}
	}
}
