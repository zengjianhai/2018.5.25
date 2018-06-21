<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.briup.bean.CatalogDetail"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.bean.Catalog"%>
<%@page import="com.briup.dao.CatalogDao"%>
<%@ page import="com.briup.bean.User"%>
<%!CatalogDao dao = new CatalogDao();
	Catalog catalog = dao.findAllCatalog();
	List<CatalogDetail> lists;
	User user;%>
<%
	user = (User) session.getAttribute("user");
%>
<script type="text/javascript" src="js/search.js">
</script>
<div class="header3">
	<a href="index.jsp"><img src="images/logo.png"></a>
	<div class="h3_center">
		<div class="search_box">
			<input type="text" id="target" /> <span onclick="search()" style="cursor:pointer">搜索</span>
		</div>
		<p>
			<%
				for (String str : catalog.getCatalogs()) {
			%>
			<a href="list.jsp?catalog=<%=str%>"><%=str%></a>|
			<%
				}
			%>
		</p>
	</div>
	<%
		if (user != null) {
	%>
	<div class="h3_right">
		<div class="myyy">
			<a href="userinfo.jsp">个人信息</a> <span class="sj_down"></span>
		</div>
		<div class="tsc">
			<a href="shopCart.jsp">去购物车结算</a> <span class="sj_right"></span>
		</div>
	</div>
	<%
		}
	%>
</div>
<!--头部导航-->
<div class="nav_top">
	<div class="nav_top_center">
		<div>全部图书分类</div>
		<ul>
			<%
				for (String str : catalog.getCatalogs()) {
			%>
			<li><a href="list.jsp?catalog=<%=str%>"><%=str%></a></li>
			<%
				}
			%>
		</ul>
	</div>
</div>
