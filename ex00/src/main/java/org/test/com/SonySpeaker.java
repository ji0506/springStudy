package org.test.com;

public class SonySpeaker implements Speaker {
	public SonySpeaker()
	{
		System.out.println("sony 스피커 객체새엉");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("sam v u");	
	}
	@Override
	public void volumeDown() {
		System.out.println("sam v d");
	}
}
