package com.briup.aop;

public class Hello2 implements Hello{

	@Override
	public void printHelloWorld() {
		System.out.println("--------hello2��printHelloWorld---------");
		return;
	}

	@Override
	public String doPrint() {
		System.out.println("--------hello2��doPrint---------");
		return "doPrint";
	}

}
