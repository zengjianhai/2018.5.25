package com.briup.java_bean.factory;

public class Cat implements Annimal{
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public void annimalName() {
		System.out.println(name+"½ΠΙωίχίχίχ");
	}
}
