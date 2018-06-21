package com.briup.test.struts;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
@Namespace(value="/annotation")
@ResultPath("/WEB-INF/content")
public class TransitionAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List users;
	
	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}


	@Action(value="transition",results={
			@Result(name=ERROR,location="/WEB-INF/content/error.jsp")
			})
	public String execute() throws Exception {
		System.out.println("----执行到了annoaction----"+getUsers());
		User user = (User)getUsers().get(0);
		if(user.getName().equals("zeng")&&user.getPass().equals("min")){
			addActionMessage("来了一条通知");
		}else{
			addActionError("第二条错误信息");
		}
		return ERROR;
	}
}
