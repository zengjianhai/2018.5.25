package com.briup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/confirm.do")
public class ConfirmServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pros=req.getParameter("product_ids");
		String allcount=req.getParameter("allcount");
		String amount=req.getParameter("amount");
		String allprice=req.getParameter("allprice");
		System.out.println(pros+":"+allcount+":"+allprice+":"+amount);
		resp.sendRedirect("http://localhost:8888/briup-book/confirm.jsp?allcount="+allcount+""
				+ "&allprice="+allprice+"&pros="+pros+"&amount="+amount+"");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
