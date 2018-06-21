package com.briup.java_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.briup.bean.OneStudent;
import com.briup.bean.Penpals;
import com.briup.impl.Pen;
import com.briup.impl.Student;

@Configuration
public class App {
	@Bean
	public BookDao book() {
		return new BookDao();
	}

	@Bean
	public OrderDao orderDao() {
		return new OrderDao();
	}
	
	@Bean
	public Student student(){
		OneStudent oneStudent = new OneStudent();
		oneStudent.setPen(pen());
		return oneStudent;
	}
	
	@Bean
	public Pen pen(){
		return new Penpals();
	}
}
