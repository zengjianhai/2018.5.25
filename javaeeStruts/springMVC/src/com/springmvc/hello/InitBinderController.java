package com.springmvc.hello;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.bean.User;

@RequestMapping("InitBinder")
@Controller
public class InitBinderController {
	
	@RequestMapping("test1")
	public String test1(User user){
		System.out.println("user="+user);
		return "model";
	}
	//第一种解决日期方案
	@InitBinder
	public void test(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
