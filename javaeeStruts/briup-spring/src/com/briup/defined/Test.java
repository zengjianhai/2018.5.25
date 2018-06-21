package com.briup.defined;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/briup/defined/defined.xml");
		Bus bus = context.getBean("bus",Bus.class);
		System.out.println(bus.toString());
	}
}
