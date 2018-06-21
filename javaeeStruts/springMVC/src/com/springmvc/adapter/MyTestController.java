package com.springmvc.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class MyTestController implements MyController {

	@Override
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;chartset=utf-8");
		String name = request.getParameter("name");
		ModelAndView mView=new ModelAndView("index");
		mView.addObject("name", name);
		return mView;
	}

}
