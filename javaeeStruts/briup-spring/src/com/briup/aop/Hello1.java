package com.briup.aop;

public class Hello1 implements Hello{

	@Override
	public void printHelloWorld() {
		System.out.println("--------hello1��printHelloWorld---------");
		return;
	}

	@Override
	public String doPrint() {
		System.out.println("--------hello1��doPrint---------");
		return "doPrint";
	}

}
