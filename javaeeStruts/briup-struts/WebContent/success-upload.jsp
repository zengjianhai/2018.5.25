<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><a:text name="register" /></title>
</head>
<body>
	文件标题:
	<a:property value=" + title" />
	<br /> 文件:
	<img src="<a:property value="'upload/' + uploadFileName"/>" />
	<br />
</body>
</html>