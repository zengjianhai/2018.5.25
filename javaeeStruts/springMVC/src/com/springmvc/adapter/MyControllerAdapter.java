package com.springmvc.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

/**
 * 只适配于实现了自定义MyController接口的handler
 * @author xunfeng
 *
 */
public class MyControllerAdapter implements HandlerAdapter{

	//判断是否实现了MyController接口
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof MyController);
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return ((MyController)handler).test(request, response);
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return 0;
	}

}
