<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="register"/></title>
</head>
<body>
	<a:form action="register" validate="true" >
		<a:textfield name="userName" key="user"></a:textfield>
		<a:textfield name="passWord" key="pass"></a:textfield>
		<a:textfield name="rePassWord" key="repass"></a:textfield>
		<a:submit key="register"/>
	</a:form>
</body>
</html>