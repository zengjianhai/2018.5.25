package com.briup.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dog")
public class Dog {
	@Value("����һֻ��")
	private String name;
	@Value("����������")
	private String Shape;
	public String say(){
		return "�ҵĶ��ӽ�ʲô";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShape() {
		return Shape;
	}
	public void setShape(String shape) {
		Shape = shape;
	}
	public Dog() {
	}
	public Dog(String name, String shape) {
		super();
		this.name = name;
		Shape = shape;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", Shape=" + Shape + "]";
	}
}
