package com.briup.struts;

public interface Action {
	public static final String ERROR="error";
	public static final String SUCCESS="success";
	public String execute() throws Exception;
}
