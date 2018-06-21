package com.login.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.login.bean.User;
import com.login.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("LoginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception {
		if(null==getUser()){
			return INPUT;
		}
		int value = userService.hasUser(getUser().getName(), getUser().getPasswd());
		System.out.println("找到了value="+value);
		boolean flag= false;
		if(value>0){
			flag = true;
		}
		if(!flag){
			addActionError("第二条错误信息");
			return INPUT;
		}else{
			return SUCCESS;
		}
	}
}
