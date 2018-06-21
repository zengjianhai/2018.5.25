package com.briup.java_bean.factory;

public class Factory {
	public static Annimal getAnnimal(String name) {
		if (name.equalsIgnoreCase("dog")) {
			return new Dog();
		} else {
			return new Cat();
		}
	}
}
