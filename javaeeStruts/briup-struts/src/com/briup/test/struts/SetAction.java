package com.briup.test.struts;

import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
@Namespace(value="/annotation")
@ResultPath("/WEB-INF/content")
public class SetAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Set users;
	
	public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}


	@Action(value="set",results={
			@Result(name=ERROR,location="/WEB-INF/content/error.jsp")
			})
	public String execute() throws Exception {
		System.out.println("----执行到了annoaction----"+getUsers());
		User user=null;
		for (Object object : getUsers()) {
			user = (User) object;
			System.out.println("-----user-----"+user);
			break;
		}
		if(user.getName().equals("zeng")&&user.getPass().equals("min")){
			addActionMessage("来了一条通知");
		}else{
			addActionError("第二条错误信息");
		}
		return ERROR;
	}
}
