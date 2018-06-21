package com.briup.test.struts;


import com.opensymphony.xwork2.ActionSupport;
public class RegistAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String rePassWord;

	public String getRePassWord() {
		return rePassWord;
	}

	public void setRePassWord(String rePassWord) {
		this.rePassWord = rePassWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String execute() throws Exception {
		System.out.println("passWd:"+getPassWord());
		return SUCCESS;
	}
}
