package com.springmvc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserSecurityInterceptor implements HandlerInterceptor {

	private List<String> excludedUrls;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("------------afterCompletion-----------------");
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("------------postHandle-----------------");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("-----------preHandle-------------");
		HttpSession session = arg0.getSession();
		if (session.getAttribute("user") == null) {
			System.out.println(arg0.getContextPath());
			arg1.sendRedirect(arg0.getContextPath() + "/user");
			return false;
		} else {
			return true;
		}
	}

}
