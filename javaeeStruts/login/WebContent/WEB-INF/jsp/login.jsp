<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
</head>
<body>
	<c:if test="${!empty error }">
		<font color="red"><c:out value="${error }"></c:out></font>
	</c:if>
	<form action='<c:url value="/loginCheck.html"/>' method="post">
		用户名：
		<input type="text" name="name"><br>
		密码：
		<input type="password" name="passwd"><br>
		<input type="submit" value="登录">
		<input type="reset" value="重置">
	</form>
</body>
</html>
