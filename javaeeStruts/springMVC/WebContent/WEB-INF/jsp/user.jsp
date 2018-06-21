<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- spring标签库 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user</title>
</head>
<body>
	<%-- <form action="result" method="get">
		名字：<input type="text" name="name"><br>
		年龄：<input type="number" name="age"><br>
		<input type="submit">
	</form> --%>
	<form:form action="result" method="get" modelAttribute="user">
		名字：<form:input path="name"/><br>
		年龄：<form:input path="age"/><br>
		<input type="submit">
	</form:form>
</body>
</html>