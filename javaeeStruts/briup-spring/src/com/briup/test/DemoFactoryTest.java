package com.briup.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.java_bean.beanfactory.News;

public class DemoFactoryTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext aContext = new ClassPathXmlApplicationContext("/com/briup/java_bean/beanfactory/beanfactory.xml");
		News news = aContext.getBean("demo",News.class);
		news.setTitle("as");
		System.out.println(news.getTitle());
		System.out.println(aContext.getBean("&demo"));
	}
}
