package com.briup.exception;

public class MyExceptionS {
	public void a() {
		try {
			throw new MyException("自定义");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyExceptionS myExceptionS = new MyExceptionS();
		try {
			myExceptionS.a();
		} catch (Exception e) {
			System.out.println("=======");
		}
	}
}
