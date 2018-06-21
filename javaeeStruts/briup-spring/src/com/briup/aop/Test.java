package com.briup.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		 ApplicationContext ctx = 
		            new ClassPathXmlApplicationContext("aopAnnotation.xml");
		 Hello annotation = (Hello) ctx.getBean("hello");
		 annotation.printHelloWorld();
		 annotation.doPrint();
//		    Hello1 hw1 = (Hello1)ctx.getBean("hello1");
//		    Hello2 hw2 = (Hello2)ctx.getBean("hello2");
//		    hw1.printHelloWorld();
//		    System.out.println();
//		    hw1.doPrint();
//		    
//		    System.out.println();
//		    hw2.printHelloWorld();
//		    System.out.println();
//		    hw2.doPrint();
		 
	}

}
