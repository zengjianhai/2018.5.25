package com.briup.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		Map<String, String> map = new HashMap<String, String>();
		map.put("age", "my miner");
		map.put("name", "is me");
		JSONArray jsonArray = JSONArray.fromObject(map);
		System.out.println(jsonArray.toString());
		PrintWriter out=resp.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
