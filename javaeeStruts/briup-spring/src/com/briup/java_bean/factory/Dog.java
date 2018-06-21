package com.briup.java_bean.factory;

public class Dog implements Annimal{
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void annimalName() {
		System.out.println(name+"½ĞÉùÍôÍôÍô");
	}

}
