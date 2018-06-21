<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>结算页面</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/orderSure.css" />
</head>
<script type="text/javascript" src="js/confirm.js">
</script>
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
	<p class="orderButtom">填写并核对订单信息</p>
    <!--中间复杂部分-->
    <div class="content">
    	<div class="contentCenter">
    		<div class="centerTop">
    			<b style="font-size:20px;">收货人信息</b>
    			<p style="font-size:15px;">
					收件人姓名：<input type="text" name="name" id="name"><br/><br/>
					收件人地址：<input type="text" name="address" class="" id="address"><br/><br/>
					收件人电话：<input type="text" name="tel" id="tel">
				</p>
    		</div>
    		<p class="singleP"><b>送货清单</b><span><a href="shopCart.jsp">返回修改购物车</a></span></p>
    		<div class="bigDiv">
    			<div class="twoDiv">
    				<b>商家：briup自营</b>
    				<jsp:include page="include/confirm_copy.jsp" flush="true"></jsp:include>
    			</div>
    		</div>
			<%
				int freight=0;
			%>
    		<div class="money">
    			<span><font><%=request.getParameter("allcount") %></font>件商品，总商品金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥<%=request.getParameter("allprice") %></span>
    			<span><img src="images/sureLogo_18.png" alt="">运费：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥<%=freight %>.00</span>
    			
    			<span>应付总额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥<%=Integer.parseInt(request.getParameter("allprice").trim())+freight %>.00</span>
    		</div>
    		<div class="submit">
    			<span>应付金额：<font>¥<%=Integer.parseInt(request.getParameter("allprice").trim())+freight %>.00</font>
    				<img src="images/21_03.png" alt="" onclick="sub('<%="order.do"%>','<%=request.getParameter("pros")%>','<%=request.getParameter("amount")%>')">
    			</span>
    		</div>
    	</div>

    </div>
	  <!--脚部-->
    <jsp:include page="include/bottom.jsp" flush="true"></jsp:include>
</body>
</html>