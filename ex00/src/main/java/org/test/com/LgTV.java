package org.test.com;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	public void powerOn() {
		System.out.println("Lg p on");
	}
	public void powerOff() {
		System.out.println("Lg p off");	
	}
	public void volumeUp() {
		System.out.println("Lg v u");	
	}
	public void volumeDown() {
		System.out.println("Lg v d");
	}

}
