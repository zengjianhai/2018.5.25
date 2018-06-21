<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>空购物车页面</title>
<link rel="stylesheet" href="css/emptyCar.css" />
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
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
	<!--中间部分-->
	<div class="empty">
	<img src="images/empty_03.png" class="car">
	</div>
  <!--脚部-->
    <jsp:include page="include/bottom.jsp" flush="true"></jsp:include>
</body>
</html>