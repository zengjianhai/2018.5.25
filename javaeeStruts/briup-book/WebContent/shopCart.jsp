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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>购物车页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<script type="text/javascript" src="js/shopcar.js"></script>
<body>
	<!--顶部-->
	<jsp:include page="include/roof.jsp"></jsp:include>
    <!--头部-->
    <div class="header3">
    	<a href="#"><img src="images/logo.png"  class="oneImg"></a>
    	

        <div class="h3_right">
        	<img src="images/play_03.png" alt="">
        </div>
       
    </div>
<!--中间部分div-->
<div class="empty">
	<div class="peisong"><pre>全部商品  <%=allCount %> </pre></div>
	<div class="mainCenter">
		<div class="allCheck">
			<input type="checkbox" name="all" onclick="change()"><p>全选</p>
			<p class="leftM">商品</p>
			<p class="rightM">单价(元)</p>
			<p class="leftM">数量</p>
			<p class="leftM">小计(元)</p>
			<p class="leftM">操作</p>
		</div>
		<div class="mainPro">
			<div class="aa">
				<input type="checkbox"><span id="but">自营</span>
			</div>
			<jsp:include page="include/shopcar_copy.jsp" flush="true"></jsp:include>
		</div>
		<div class="allButtom">
			<p class="caozuo" onclick="account()">去结算</p>
			<span>已选择<font id="allcount">0</font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font>¥</font><font id="allprice">0</font><font>.00元</font></span>
		</div>
	</div>
</div>
     <!--脚部-->
    <jsp:include page="include/bottom.jsp" flush="true"></jsp:include>
</body>
</html>