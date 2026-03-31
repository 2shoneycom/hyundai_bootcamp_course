package com.spring_aop.xml2;

public class Evaluation {
	private int korean;
	private int english;
	private int math;
	
	public int sum() {
		return korean + english + math;
	}
	
	public float avg() {
		return (float)sum() / 3;
	}
	
	public void show() {
		System.out.println("총합: " + sum() + ", 평균: " + avg());
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
}
