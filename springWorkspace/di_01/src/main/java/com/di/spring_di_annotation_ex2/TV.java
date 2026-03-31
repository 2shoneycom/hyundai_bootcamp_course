package com.di.spring_di_annotation_ex2;

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
