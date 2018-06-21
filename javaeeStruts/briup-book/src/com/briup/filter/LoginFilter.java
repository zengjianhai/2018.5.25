package com.briup.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;

public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		// 获得用户请求的URI
		String path = req.getRequestURI();
		User user = (User) session.getAttribute("user");
		System.out.println("user:  " + user + " path:  " + path);
		// 要过滤的页面
		String[] pages = { "/confirm.jsp", "/emptyCar.jsp", "/shopCart.jsp", "/userinfo.jsp" };
		// 过滤
		boolean flag = false;
		for (int i = 0; i < pages.length; i++) {
			if (path.indexOf(pages[i]) > -1) {
				flag = true;
			}
		}
		if (flag) {

		} else {
			// 登陆页面无需过滤
			chain.doFilter(req, resp);
			return;
		}
		// 判断如果没有取到员工信息,就跳转到登陆页面
		if (user == null || "".equals(user)) {
			// 跳转到登陆页面
			resp.sendRedirect("http://localhost:8888/briup-book/index.jsp");
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
