package com.briup.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.briup.test.struts.User;

public class UserConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.err.println("-----------类型转换User-------------");
		String[] params = arg1;
		for (int i = 0; i < params.length; i++) {
			params[i]=params[i].toUpperCase();
			System.out.println(params[i]);
		}
		User user = new User();
		user.setName(params[0]);
		user.setPass(params[1]);
		return user;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.err.println("-----------类型转换String-------------");
		User user = (User)arg1;
		return user.getName()+","+user.getPass();
	}
}
