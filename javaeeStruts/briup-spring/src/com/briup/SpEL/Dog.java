package com.briup.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dog")
public class Dog {
	@Value("这是一只狗")
	private String name;
	@Value("它有四条脚")
	private String Shape;
	public String say(){
		return "我的儿子叫什么";
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
