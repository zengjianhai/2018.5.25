package com.briup.aop;

public class Hello1 implements Hello{

	@Override
	public void printHelloWorld() {
		System.out.println("--------hello1µÄprintHelloWorld---------");
		return;
	}

	@Override
	public String doPrint() {
		System.out.println("--------hello1µÄdoPrint---------");
		return "doPrint";
	}

}
