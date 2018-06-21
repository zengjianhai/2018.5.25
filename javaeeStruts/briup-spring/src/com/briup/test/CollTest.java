package com.briup.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Coll;
import com.briup.bean.Person;

public class CollTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// 读取bean.xml中的内容
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean2.xml");
		// 创建bean的引用对象
		Coll coll = ctx.getBean("collTo", Coll.class);
		System.out.println(coll);
	}
}
