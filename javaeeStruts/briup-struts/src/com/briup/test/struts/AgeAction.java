package com.briup.test.struts;


import com.opensymphony.xwork2.ActionSupport;
public class AgeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String execute() throws Exception {
		System.out.println("age:"+getAge());
		return SUCCESS;
	}
}
