package com.spring_mvc.DTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private String no;
	private String name;
	private int year;
	// Date 타입의 형식을 결정하는 annotation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
