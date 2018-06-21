<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="loginPage" /></title>
</head>
<body>
	<a:debug></a:debug>
	<a:form action="ageerror" theme="simple">
		<a:textfield name="age" key="age"></a:textfield>
		${fieldErrors.age[0] }<br/>
		<a:fielderror fieldName="age"></a:fielderror>
		<a:submit key="login"></a:submit>
	</a:form>
	本站访问次数：${applicationScope.counter}<br/>
</body>
</html>