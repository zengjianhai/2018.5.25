<%@ page import="com.briup.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%!User user;%>
<%
	user = (User) session.getAttribute("user");
%>
<div class="top">
	<div class="top_center">
		<ul class="top_bars">
			<%
				if (user != null) {
			%>
			<li class="lioption"><a href="userinfo.jsp" class="first-a">hi
					<%=user.getName()%></a>|
				<div class="option">
					<a href="index.do">退出登录</a>
				</div></li>
			<%
				} else {
			%>
			<li><a href="login.jsp">登录</a>|</li>
			<%
				}
			%>
			<li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
			<li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
			<li><a href="#">网站导航<span class="jt_down"></span></a></li>
		</ul>
	</div>
</div>