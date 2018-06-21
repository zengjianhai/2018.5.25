package com.briup.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext aContext=new ClassPathXmlApplicationContext("/com/briup/SpEL/SpEL.xml");
		Animal animal = (Animal)aContext.getBean("animal");
		System.out.println(animal);
	}
}
