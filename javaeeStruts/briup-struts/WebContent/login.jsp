<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="loginPage" /></title>
</head>
<script type="text/javascript">
	function registgo(){
		alert("this");
		targetForm = document.forms[0];
		targetForm.action="login!regist";
	}
</script>
<body>
	<a:form action="login">
		<a:textfield name="userName" key="user"></a:textfield>
		<a:textfield name="passWd" key="pass"></a:textfield>
		<a:fielderror fieldName="passWd"/><br/>
		<a:submit key="login"></a:submit>
		<a:submit key="regist" onclick="registgo()"/>
	</a:form>
	本站访问次数：${applicationScope.counter}<br/>
</body>
</html>