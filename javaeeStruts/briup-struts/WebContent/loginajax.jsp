<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="loginPage" /></title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>
<body>
	<a:form id="loginForm">
		<a:textfield name="userName" key="user"></a:textfield>
		<a:textfield name="passWd" key="pass"></a:textfield>
		<input value="login" id="loginBtn" type="button" />
	</a:form>
	本站访问次数：${applicationScope.counter}
	<br />
	<div id="show" style="display: none;"></div>
	<script type="text/javascript">
		$(function() {
			$('#loginBtn').click(
					function() {
						alert("-------");
						$.get("loginPro", $("#loginForm").serializeArray(),
								function(data, statusText) {
									$("#show").height(80).width(300).css(
											"color", "#ff0000").empty();
									$("#show").append("登录结果:" + data + "<br/>");
									$("#show").show(2000);
								}, "html");
					});
		})
	</script>
</body>
</html>