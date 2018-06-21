package com.briup.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("book.xml");
		TestBean testBean = (TestBean)aContext.getBean("test");
		ResourceLoader resourceLoader = testBean.getResourceLoader();
		System.out.println(aContext==resourceLoader);
		Two two= (Two)aContext.getBean("two");
		System.out.println(two);
	}
	
}
