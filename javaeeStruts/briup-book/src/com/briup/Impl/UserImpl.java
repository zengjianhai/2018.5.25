package com.briup.Impl;

import com.briup.bean.User;

public interface UserImpl {
	public void addUser(User user);
	public boolean findUserByName(String name);
	public User findUserByNameAndPwd(String name,String pass);
	public int findUserIdByName(String name);
	public void updateUser(User user);
}
