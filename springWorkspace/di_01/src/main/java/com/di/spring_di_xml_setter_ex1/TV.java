package com.di.spring_di_xml_setter_ex1;

public class TV {
	Speaker speaker;
	
	public void setSpeaker (Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		System.out.println("TV's " + speaker.volumeUp());
	}
	
	public void volumeDown() {
		System.out.println("TV's " + speaker.volumeDown());
	}
}
