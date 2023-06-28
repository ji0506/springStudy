package org.test.com;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker()
	{
		System.out.println("appale 스피커 객체새엉");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("apple v u");	
	}
	@Override
	public void volumeDown() {
		System.out.println("apple v d");
	}
}
