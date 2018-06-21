package com.briup.java_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class AppConfig {

	@Resource(name="bookDao")
	private BookDao bookDao;
	@Resource(name="orderDao")
	private OrderDao orderDao;
	public void add() {
		System.out.println("------add-------");
		bookDao.book();
		orderDao.order();
	}
	@PostConstruct
	public void init(){
		System.out.println("-------init----------");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("-------destroy----------");
	}
}
