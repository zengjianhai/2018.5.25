package com.briup.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Coll;
import com.briup.bean.Person;

public class CollTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// ��ȡbean.xml�е�����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
		// ����bean�����ö���
		Coll coll = ctx.getBean("collTo", Coll.class);
		System.out.println(coll);
	}
}
