<%@page import="com.briup.dao.UserDao"%>
<%@page import="com.briup.bean.User"%>
<%@page import="com.briup.dao.ShopDao"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.bean.ShopProduct"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%!
	List<ShopProduct> lists;
	ShopDao sDao = new ShopDao();
	UserDao userDao = new UserDao();
	User user;
%>
<%
	user = (User)session.getAttribute("user");
	lists = sDao.findShopByUserName(user);
	int allCount = 0;
	for(ShopProduct sProduct:lists){
		allCount =allCount+sProduct.getAmount();
	}
%>
			<%	
				int i=0;
				for(ShopProduct sProduct:lists){
			%>
			<div class="bb">
				<input type="checkbox"  class="bbnextinput" value="<%=sProduct.getAmount() %>" name="yesorno" onclick="change()">
				<input type="hidden" value="<%=sProduct.getProduct().getPrice() %>" name="price">
				<input type="hidden" value="<%=sProduct.getProduct().getId() %>" name="pro_id">
				<img height="80px" width="80px" src="<%=sProduct.getProduct().getImg() %>" >
				 <span>
                   	<%=sProduct.getProduct().getName() %>
                    <br>
                </span>
               	<div class="righ">
               		 <div class="rig" onclick="delPro('<%="shopcar.do" %>','<%=sProduct.getProduct().getId() %>','<%="yes" %>')">删除</div>
               	</div>
                <div class="ri">¥<%=sProduct.getProduct().getPrice()*sProduct.getAmount() %>元</div>
                <div class="addanddel">
                    <dl>
                    	<dd onclick="add(<%=i %>)">&nbsp;+</dd>
                    </dl>
                	<input type="text" value="<%=sProduct.getAmount() %>" id="count" name="count" class="addio"/>
                    <dl>
                    	<dd onclick="del(<%=i %>)">&nbsp;-</dd>
                    </dl>
                </div>
                <div class="mm">
                	<span>¥<%=sProduct.getProduct().getPrice() %></span>
                </div>
			</div>
			<%
					i++;
				}
			%>			