package com.briup.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("animal")
public class Animal {
	@Value("#{dog}")
	private Dog dog;
	@Value("#{dog.name}")
	private String name;
	@Value("#{dog.say()}")
	private String content;
	public Animal(Dog dog, String name, String content) {
		super();
		this.dog = dog;
		this.name = name;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal() {
	}
	@Override
	public String toString() {
		return "Animal [dog=" + dog + ", name=" + name + ", content=" + content + "]";
	}
}
