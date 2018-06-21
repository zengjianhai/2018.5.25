package com.briup.ajax.struts;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userName;
	private String passWd;
	private InputStream inputStream;

	public InputStream getResult() {
		System.out.println("this is result");
		return inputStream;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	public String execute() throws Exception {
		System.out.println("-----执行到了loginPro------");
		inputStream = userName.equals("zeng")&&passWd.equals("min")?new ByteArrayInputStream
				("登录成功".getBytes("utf-8")):new ByteArrayInputStream("登录失败".getBytes("utf-8"));
		return SUCCESS;
	}

}
