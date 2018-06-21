package com.springmvc.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MyController {
	ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
