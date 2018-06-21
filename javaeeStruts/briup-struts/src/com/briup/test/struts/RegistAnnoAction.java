package com.briup.test.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class RegistAnnoAction extends ActionSupport {
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

	@RequiredStringValidator(key = "user.required", message = "")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	@RequiredStringValidator(key = "pass.required", message = "", shortCircuit = true)
	@RegexFieldValidator(regexExpression = "\\w{6,15}", key = "pass.regex", message = "")
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public void validate() {
		System.out.println("----进入validate方法执行----");
		if (userName != null) {
			System.err.println("-----------");
			if(!userName.equals("min")){
				addFieldError("userName", "名字必须为min");
			}
		}

	}

	public String execute() throws Exception {
		System.out.println("passWd:" + getPassWord());
		return SUCCESS;
	}
}
