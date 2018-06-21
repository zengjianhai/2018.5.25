package com.briup.test.struts;

import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/annotation")
@ResultPath("/WEB-INF/content")
public class TestAnnoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user= user;
	}
	@Action(value="execute",results={
			@Result(name=ERROR,location="/WEB-INF/content/error.jsp")
			})
	public String execute() throws Exception {
		System.out.println("----执行到了annoaction----");
//		addActionError("第一条错误信息");
//		addActionError("第二条错误信息");
		if(getUser().getName().equals("ZENG")&&getUser().getPass().equals("MIN")){
			addActionMessage("来了一条通知");
		}else{
			addActionError("第二条错误信息");
		}
		return ERROR;
	}
}
