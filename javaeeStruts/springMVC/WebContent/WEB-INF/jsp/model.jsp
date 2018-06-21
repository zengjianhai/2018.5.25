<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${user }
	<br /> ${user.name }
	<hr />
	<%
		Enumeration<String> enums = request.getAttributeNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();
			/* out.write(key); */
			if (key.equals("user")) {
				Object value = request.getAttribute(key);
				out.write(value + "");
			}
	%>
	<hr />
	<%
		}
	%>
</body>
</html>