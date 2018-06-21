package com.briup.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.EmailEvent;
import com.briup.impl.Student;

public class StudentTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Student oneStudent = ac.getBean("oneStudent", Student.class);
		oneStudent.usePen();
		Student twoStudent = ac.getBean("twoStudent", Student.class);
		twoStudent.usePen();
		Student threeStudent = ac.getBean("threeStudent", Student.class);
		threeStudent.usePen();
		String name=ac.getMessage("name", args, "",Locale.getDefault());
		System.out.println("name:"+name);
		EmailEvent event = new EmailEvent("object","½­Î÷","ÄÚÈÝ");
		ac.publishEvent(event);
		System.out.println(ac.getBean("penp")==ac.getBean("penp"));
	}
}
