package com.briup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.ShopCar;
import com.briup.bean.User;
import com.briup.dao.AddDao;
import com.briup.dao.UserDao;

@WebServlet("/viewBook.do")
public class ViewBook extends HttpServlet {
	UserDao dao;
	AddDao addDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		boolean flag = false;
		int amount = 0;
		if (dao == null) {
			dao = new UserDao();
		}
		if (addDao == null) {
			addDao = new AddDao();
		}
		ShopCar shopCar = null;
		User user = null;
		HttpSession session = req.getSession();
		user = (User) session.getAttribute("user");

		String count = req.getParameter("count");
		String product_id = req.getParameter("product_id");
		String loog = req.getParameter("flag");
		int id = 0;
		if (user == null) {
			out.write("再不切灯录，就卖元里");
			out.flush();
		} else {
			id = dao.findUserIdByName(user.getName());
			System.out.println("loop:" + loog);
			System.out.println(id + ":" + product_id);
			amount = addDao.findShopCarByUserIdAndProId(id, Integer.parseInt(product_id.trim()));
			if ("true".equals(loog)) {
				addDao.updataShopCar(Integer.parseInt(count.trim()) + amount, id, Integer.parseInt(product_id.trim()));
				return;
			} else {
				if (amount > 0) {
					flag = true;
				}
				if (flag) {
					System.err.println("第一次发送更新请求");
					out.write("update");
					out.flush();
				} else {
					System.out.println("添加成功");
					shopCar = new ShopCar(Integer.parseInt(product_id), Integer.parseInt(count), id);
					addDao.addShopCar(shopCar);
					out.write("add");
					out.flush();
					return;
				}
			}
		}
		System.out.println(flag + "------------" + product_id + ":" + count);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
