package com.briup.converter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import com.briup.test.struts.User;
import com.opensymphony.xwork2.conversion.TypeConversionException;

public class UserSetConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.err.println("-----------set类型转换User-------------");
		Set result = new HashSet<>();
		User user = new User();
		String[] params = arg1;
		user.setName(params[0]);
		user.setPass(params[1]);
		result.add(user);
		System.out.println("----set-----" + result);
		return result;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.err.println("-----------set类型转换String-------------");
		if (arg1.getClass() == Set.class) {
			Set uSet = (Set) arg1;
			String result = "[";
			for (Object object : uSet) {
				User user = (User) object;
				result += user.getName() + "," + user.getPass();
			}
			return result + "]";
		} else {
			return "";
		}
	}
}
