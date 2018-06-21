package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.dao.UserDao;

@WebServlet("/login.do")
public class Login extends HttpServlet{
	UserDao dao;
	User user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao = new UserDao();
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		System.err.println(name+":"+pwd);
		HttpSession session = req.getSession();
		user = dao.findUserByNameAndPwd(name, pwd);
		if(user!=null&&user.getName()!=null){
			resp.sendRedirect("http://localhost:8888/briup-book/index.jsp");
			session.setAttribute("user", user);
		}else{
			resp.sendRedirect("http://localhost:8888/briup-book/login.jsp");
			session.setAttribute("user", null);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
