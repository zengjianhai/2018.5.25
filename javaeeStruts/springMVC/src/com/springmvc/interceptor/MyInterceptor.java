package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("-----------×Ô¶¨Òå-------------");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("user"));
		if (session.getAttribute("user") == null) {
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/user");
			return false;
		} else {
			return true;
		}
	}

}
