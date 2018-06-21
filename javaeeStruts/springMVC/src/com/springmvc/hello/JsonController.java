package com.springmvc.hello;

import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.bean.User;

@RequestMapping("Json")
@Controller
public class JsonController {

	@RequestMapping(value = "test1", method = RequestMethod.POST, consumes = "application/json")
	public void test1(@RequestBody String user, Writer out) throws Exception {
		System.out.println("user=" + user);
		out.write("hello world");
		out.flush();
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.POST, consumes = "application/json")
	public void test2(@RequestBody User user, Writer out) throws Exception {
		System.out.println("user=" + user);
		out.write("hello world");
		out.flush();
	}
	
	//响应回修改的数据
	@RequestMapping(value = "test3", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public User test3(@RequestBody User user) throws Exception {
		System.out.println("user = "+user);
		user.setName("张三");
		user.setAge(16);
		return user;
	}
}
