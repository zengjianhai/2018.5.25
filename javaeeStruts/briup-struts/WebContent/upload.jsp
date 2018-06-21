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
	<a:form action="uploadPro" enctype="multipart/form-data" method="post">
		<a:textfield name="title" label="文件标题"/><br/>
		<a:file name="upload" label="选择文件"/><br/>
		<a:submit value="上传"/>
	</a:form>
</body>
</html>