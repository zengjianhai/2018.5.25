package com.briup.aop;

public class Hello2 implements Hello{

	@Override
	public void printHelloWorld() {
		System.out.println("--------hello2µÄprintHelloWorld---------");
		return;
	}

	@Override
	public String doPrint() {
		System.out.println("--------hello2µÄdoPrint---------");
		return "doPrint";
	}

}
