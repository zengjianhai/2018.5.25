package com.briup.interfacetest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class T {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		A d = (A)context.getBean("a");
		A d2 = (A)context.getBean("a");
		System.out.println(d.getCar()==d2.getCar());
	}
}
class B{
	static{
		System.out.println("----B---");
	}
	public static int val=0;
}
class C extends B{
	static{
		System.out.println("----C---");
	}
}