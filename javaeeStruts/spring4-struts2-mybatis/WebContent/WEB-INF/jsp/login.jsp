<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="loginPage" /></title>
</head>
<body>
	<a:form action="login.action" method="post">
		<a:textfield name="user.name" key="user"></a:textfield>
		<a:password name="user.passwd" key="pass"></a:password>
		<a:submit key="login"></a:submit>
		<a:reset key="regist"/>
	</a:form>
</body>
</html>
