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


@WebServlet("/userinfo.do")
public class UserInfoServlet extends HttpServlet {
	User user;
	UserDao uDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(uDao==null){
			uDao = new UserDao();
		}
		String name =req.getParameter("name");
		String pass =req.getParameter("pass");
		String code =req.getParameter("code");
		String address =req.getParameter("address");
		String tel =req.getParameter("tel");
		String email =req.getParameter("email");
		user = new User(name, pass, address, tel, email, code);
		uDao.updateUser(user);
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
