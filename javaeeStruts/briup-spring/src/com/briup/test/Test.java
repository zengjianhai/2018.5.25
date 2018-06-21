package com.briup.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Person;


public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// 读取bean.xml中的内容
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		// 创建bean的引用对象
		Person p = ctx.getBean("person", Person.class);
		p.info();
	}
}
