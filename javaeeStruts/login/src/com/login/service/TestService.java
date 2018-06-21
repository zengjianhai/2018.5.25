package com.login.service;

import java.sql.SQLException;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestService {

	@Test
	public void hasUser() throws SQLException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = context.getBean(UserService.class);
		int flag = userService.hasUser("miner", "0622");
		System.out.println(flag);
	}
	
}
