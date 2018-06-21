<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn1').on("click", function() {
			var jsonObj = {
				name : "tom",
				age : 20
			};
			$.ajax({
				type : "POST",
				url : "Json/test3",
				contentType : "application/json",
				data : JSON.stringify(jsonObj),
				dateType: "json",
				success : function(msg) {
					console.log("msg = "+JSON.stringify(msg));
					console.log(msg.name);
					console.log(msg.age);
				}
			});
		});
	});
</script>
<body>miner
	<input id="btn1" type="button">
</body>
</html>