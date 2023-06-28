package org.test.com;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Bean {
	public Object getBean(String name) {
		if(name.equals("sansung"))
			return new SamsungTV();
		else if(name.equals("lg"))
			return new LgTV();
	
		return null;
	}
	
	
	public static void main(String[] args)
	{
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOn();
		
		factory.close();

	}
}
