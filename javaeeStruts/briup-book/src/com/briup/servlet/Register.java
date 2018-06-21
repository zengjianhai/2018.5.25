package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.User;
import com.briup.dao.UserDao;

@WebServlet("/register.do")
public class Register extends HttpServlet{
	UserDao dao;
	User user;
	boolean flag = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dao = new UserDao();
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		String zip = req.getParameter("zip");
		String address = req.getParameter("address");
		String telephone= req.getParameter("telephone");
		String email = req.getParameter("email");
		user = new User(name, pwd, address, telephone, email, zip);
		flag = dao.findUserByName(name);
		if(!flag){
			dao.addUser(user);
			resp.sendRedirect("http://localhost:8888/briup-book/login.jsp");
		}
		System.out.println(name+":"+pwd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
