package com.briup.highbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/briup/highbean/high.xml");
		Son son1 = (Son) context.getBean("son1");
		Son son2 = (Son) context.getBean("son2");

		System.out.println("son name is:" + son1);
		System.out.println("son name is:" + son2);
		System.out.println(context.getBean("son3"));
		System.out.println(context.getBean("son4"));
		System.out.println(context.getBean("son5",Son.class));
	}
}
