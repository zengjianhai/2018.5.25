package com.briup.java_bean;

import org.springframework.beans.factory.annotation.Value;

public class BookDao {
	private @Value("miner") String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void book(){
		System.out.println("------book-----"+getName());
	}
}
