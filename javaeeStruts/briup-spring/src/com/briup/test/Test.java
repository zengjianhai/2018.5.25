package com.briup.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Person;


public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// ��ȡbean.xml�е�����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		// ����bean�����ö���
		Person p = ctx.getBean("person", Person.class);
		p.info();
	}
}
