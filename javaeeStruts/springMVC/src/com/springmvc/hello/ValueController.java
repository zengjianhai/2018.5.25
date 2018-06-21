package com.springmvc.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.bean.User;

@RequestMapping("Value")
@Controller
public class ValueController {

	@Value("briup")
	private String name;
	
	@RequestMapping("test1")
	public String test(){
		System.out.println("name="+name);
		return "model";
	}
	
	@RequestMapping("test2")
	public String test2(@Value("miner") String name){
		System.out.println("name="+name);
		return "model";
	}
	
	@RequestMapping("test3")
	public String test3(@Value("#{user.say('hello world')}") String name){
		System.out.println("name="+name);
		return "model";
	}
	
	@RequestMapping("test4")
	public String test4(@Value("#{user}") User user){
		System.out.println("name="+user.getName());
		System.out.println("age="+user.getAge());
		return "model";
	}
}
