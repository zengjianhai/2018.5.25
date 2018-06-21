package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.dao.DelDao;
import com.briup.dao.UserDao;

@WebServlet("/shopcar.do")
public class ShopCarServlet extends HttpServlet {
	UserDao dao;
	DelDao delDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----------------------");
		if (delDao == null) {
			delDao = new DelDao();
		}
		if (dao == null) {
			dao = new UserDao();
		}
		User user = null;
		HttpSession session = req.getSession();
		user = (User) session.getAttribute("user");
		int id = dao.findUserIdByName(user.getName());

		String product_id = req.getParameter("product_id");
		System.out.println(id + "-----------------------" + product_id);
		delDao.delShopcarByProIdAndUserId(Integer.parseInt(product_id), id);
		System.err.println(product_id + "------------" + id);
		if (product_id != null) {
			resp.sendRedirect("http://localhost:8888/briup-book/shopCart.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
