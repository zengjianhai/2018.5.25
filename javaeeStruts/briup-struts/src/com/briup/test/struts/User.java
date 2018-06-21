package com.briup.test.struts;

public class User {
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User(){}
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj!=null&&obj.getClass()==User.class){
			User user = (User)obj;
			if(this.getName().equals(user.getName())){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
