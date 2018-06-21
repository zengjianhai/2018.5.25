package com.briup.aop;

public class HelloAnnotation implements Hello{

	@Override
	public void printHelloWorld() {
		System.out.println("------jdk------");
	}

	@Override
	public String doPrint() {
		System.out.println("------jdk´úÀí------");
		return "jdk";
	}

}
