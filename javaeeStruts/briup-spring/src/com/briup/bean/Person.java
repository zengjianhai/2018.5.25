package com.briup.bean;

public class Person {
	private String name;
	private String age;
	public Person() {
	}
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
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
	public void info(){
		System.out.println("---执行到了bean中---");
		System.out.println("name:"+getName()+"  age:"+getAge());
	}
}
