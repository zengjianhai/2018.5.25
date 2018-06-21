package com.login.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.login.dao.IUserDao;

@Service
public class UserService {
	@Resource
	IUserDao userDao;
	public int hasUser(String name,String passwd) throws SQLException{
		return userDao.findUserByName(name, passwd);
	}
}
