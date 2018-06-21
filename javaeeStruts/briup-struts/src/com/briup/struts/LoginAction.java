package com.briup.struts;

import java.sql.SQLException;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.briup.exception.MyException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class LoginAction implements Action{
	private String userName;
	private String passWd;
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
		ActionContext act = ActionContext.getContext();
		/*
		 * preResultListener监听器
		 * */
		ActionInvocation invocation = act.getActionInvocation();
		invocation.addPreResultListener(new PreResultListener() {
			
			@Override
			public void beforeResult(ActionInvocation arg0, String arg1) {
				System.out.println("-----:"+arg1);
			}
		});
		Integer counter = (Integer) act.getApplication().get("counter");
		if (counter == null) {
			counter=1;
		} else {
			counter++;
		}
		act.getApplication().put("counter", counter);
		act.getSession().put("user", getUserName());
		if(getUserName().equalsIgnoreCase("user")){
			throw new MyException("自定义");
		}
		if(getUserName().equalsIgnoreCase("sql")){
			throw new SQLException("sql");
		}
		if (getUserName().equals("zeng") && getPassWd().equals("min")) {
			Cookie cookie = new Cookie("user", getUserName());
			cookie.setMaxAge(6);
			/*
			 * 为了避免xxAware接口与Servlet API产生的直接耦合
			 * ServletActionContext有静态的getResponse()方法
			 * */
			ServletActionContext.getResponse().addCookie(cookie);
			act.put("tip", "this is ok");
			return SUCCESS;
		} else {
			act.put("tip", "this is no");
			return ERROR;
		}
	}
	
	public String regist() throws Exception {
		return "regist";
	}
	public String login() throws Exception {
		System.err.println("----执行了login()方法----");
		ActionContext act = ActionContext.getContext();
		Integer counter = (Integer) act.getApplication().get("counter");
		if (counter == null) {
			counter=1;
		} else {
			counter++;
		}
		act.getApplication().put("counter", counter);
		act.getSession().put("user", getUserName());
		if (getUserName().equals("zeng") && getPassWd().equals("min")) {
			Cookie cookie = new Cookie("user", getUserName());
			cookie.setMaxAge(6);
			/*
			 * 为了避免xxAware接口与Servlet API产生的直接耦合
			 * ServletActionContext有静态的getResponse()方法
			 * */
			ServletActionContext.getResponse().addCookie(cookie);
			act.put("tip", "this is ok");
			return SUCCESS;
		} else {
			act.put("tip", "this is no");
			return ERROR;
		}
	}
}
