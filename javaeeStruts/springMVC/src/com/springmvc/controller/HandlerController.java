package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HandlerController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("-----------------------"+name);
		ModelAndView mv = new ModelAndView();
		//把数据放到模型中
		mv.addObject("name", name);
		//设置视图逻辑的名字
		mv.setViewName("index");
		return mv;
	}

}
