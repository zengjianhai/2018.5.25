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
		//�����ݷŵ�ģ����
		mv.addObject("name", name);
		//������ͼ�߼�������
		mv.setViewName("index");
		return mv;
	}

}
