package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Consignee;
import com.briup.bean.Order;
import com.briup.bean.User;
import com.briup.dao.AddDao;
import com.briup.dao.DelDao;
import com.briup.dao.FindDao;
import com.briup.dao.ProductDao;
import com.briup.dao.UserDao;



@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
	Consignee consignee;
	AddDao aDao;
	FindDao fDao;
	UserDao uDao;
	ProductDao pDao;
	DelDao delDao;
	Order order;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(aDao==null){
			aDao = new AddDao();
		}
		if(fDao==null){
			fDao = new FindDao();
		}
		if(uDao==null){
			uDao = new UserDao();
		}
		if(pDao==null){
			pDao = new ProductDao();
		}
		if(delDao==null){
			delDao = new DelDao();
		}
		User user = null;
		HttpSession session = req.getSession();
		user = (User) session.getAttribute("user");
		int user_id = uDao.findUserIdByName(user.getName());
		String[] pros = req.getParameter("product_ids").split("[|]");
		String[] amounts = req.getParameter("amounts").split("[|]");
		String[] nat = req.getParameter("nat").split("[|]");
		consignee = new Consignee(nat[0],nat[1],nat[2],user_id);
		int con_id =0;
		//查询是否存在这个收货人
		con_id = fDao.findConsigneeId(consignee);
		if(con_id==0){
			aDao.addConsignee(consignee);
			con_id = fDao.findConsigneeId(consignee);
		}
		for (int i = 0; i < pros.length; i++) {
			//把用户id，商品id和收货人id拼接成订单的id
			int id = Integer.parseInt(user_id+pros[i].trim()+con_id);
			order = new Order(id,Integer.parseInt(pros[i].trim()),Integer.parseInt(amounts[i].trim()),user_id,con_id);
			aDao.addOrder(order);
			pDao.updateProduct(Integer.parseInt(pros[i].trim()), Integer.parseInt(amounts[i].trim()));
			delDao.delShopcarByProIdAndUserId(Integer.parseInt(pros[i].trim()), user_id);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
