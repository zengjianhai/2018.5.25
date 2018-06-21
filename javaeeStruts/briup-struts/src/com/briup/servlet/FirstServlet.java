package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("this is servlet's destory.");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		String name = arg0.getInitParameter("name");
		System.out.println("this is servlet's info..."+name);
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<p>this is a test method</p>");
		out.write("</body>");
		out.write("</html>");
		out.flush();
	}
}
