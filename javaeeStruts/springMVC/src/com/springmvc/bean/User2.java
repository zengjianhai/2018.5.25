package com.springmvc.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min=5,max=8)
	private String name;
	@Pattern(regexp="^\\d{2}",message="ƒ„Àµ‘ı√¥¥Ì¡À??")
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public User2() {
	}
	@Override
	public String toString() {
		return "User2 [name=" + name + ", age=" + age + "]";
	}
	public User2(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String say(String say){
		return say;
	}
}
