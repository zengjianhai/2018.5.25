package com.briup.exception;


public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyException(){
		
	}
	public MyException(String msg){
		super(msg);
	}
	public MyException(String msg,Throwable throwable){
		super(msg, throwable);
	}
}
