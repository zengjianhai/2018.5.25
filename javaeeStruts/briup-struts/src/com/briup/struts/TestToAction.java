package com.briup.struts;


public class TestToAction implements Action{

	public String execute() throws Exception {
		System.out.println("----执行到了第二个action----");
		return SUCCESS;
	}
}
