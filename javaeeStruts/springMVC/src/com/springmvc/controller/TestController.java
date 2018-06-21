package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;chartset=utf-8");
		String name = request.getParameter("name");
		ModelAndView mView=new ModelAndView("index");
		mView.addObject("name", name);
		return mView;
	}

}
