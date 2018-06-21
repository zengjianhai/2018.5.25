package com.springmvc.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min=5,max=8)
	private String name;
	@Pattern(regexp="^\\d{2}",message="ƒ„Àµ‘ı√¥¥Ì¡À??")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String say(String say){
		return say;
	}
}
