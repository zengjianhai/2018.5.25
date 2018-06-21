package com.briup.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.impl.Student;
import com.briup.java_bean.App;
import com.briup.java_bean.AppConfig;
import com.briup.java_bean.BookDao;
import com.briup.java_bean.OrderDao;

public class ConfigTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext aContext = new ClassPathXmlApplicationContext("appConfig.xml");
		AppConfig appConfig = (AppConfig)aContext.getBean("appConfig");
		appConfig.add();
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext(App.class);
		BookDao bookDao = (BookDao)aac.getBean("book");
		bookDao.book();
		System.out.println("java≈‰÷√£∫"+bookDao.getName());
		OrderDao bDao = (OrderDao)aac.getBean("orderDao");
		bDao.order();
		Student student = (Student)aac.getBean("student");
		student.usePen();
	}
}
