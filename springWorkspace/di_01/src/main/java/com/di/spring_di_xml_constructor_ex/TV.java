package com.di.spring_di_xml_constructor_ex;

public class TV {
	Speaker speaker;
	
	public TV (Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		System.out.println("TV's " + speaker.volumeUp());
	}
	
	public void volumeDown() {
		System.out.println("TV's " + speaker.volumeDown());
	}
}
