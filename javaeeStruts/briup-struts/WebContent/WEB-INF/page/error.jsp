<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="error" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><error:text name="errorPage" /></title>
</head>
<body>
	<error:text name="errorTip" /><br/>
	<error:property value="exception"/><br/>
	异常信息：<error:property value="exception.message"/>
</body>
</html>