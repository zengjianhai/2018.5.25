package com.briup.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.java_bean.factory.Annimal;
import com.briup.java_bean.factory.SingleAndPrototype;
import com.briup.java_bean.factory.Tree;


public class FactoryTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
//		Annimal dog = ac.getBean("dog",Annimal.class);
//		dog.annimalName();
//		Annimal cat = ac.getBean("cat",Annimal.class);
//		cat.annimalName();
		SingleAndPrototype sing1 = ac.getBean("singandpro",SingleAndPrototype.class);
		SingleAndPrototype sing2 = ac.getBean("singandpro",SingleAndPrototype.class);
		sing1.into();
		sing2.into();
		Tree zhangshu = ac.getBean("min",Tree.class);
		zhangshu.shape();
		ac.registerShutdownHook();
 	}
}
