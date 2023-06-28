package org.test.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SamsungTV  implements TV{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	int price;
	private Speaker speaker;
	
	public void initMethod() {
		price = 0;
		
		System.out.println("test init");
	}
	
	
	public void destroyMethod()
	{
		System.out.println("test destroy");
		
	}
	public SamsungTV()
	{
		System.out.println("test 생성자 1");
	}

	public SamsungTV(Speaker speaker)
	{

		this.speaker = speaker;
		System.out.println("test 생성자 2");
	}
	
	public SamsungTV(Speaker speaker, int price)
	{
		this.price  = price;
		this.speaker = speaker;
		System.out.println("test 생성자 3");
	}

	
	public void powerOn() {
		System.out.println("sam p on");
	}
	public void powerOff() {
		System.out.println("sam p off");	
	}
	public void volumeUp() {
		speaker.volumeUp();

	}
	public void volumeDown() {
		speaker.volumeDown();
	}

	
	public static void main(String[] args)
	{
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		logger.info("Welcome home! The client locale is {}.");

	}
}
