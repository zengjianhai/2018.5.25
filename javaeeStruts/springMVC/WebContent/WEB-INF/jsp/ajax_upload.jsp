<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>static/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(function() {
		$("input:button").on("click", function() {
			if (!$("input:file").val()) {
				alert("请选择上传文件");
				return;
			}
			ajaxFileUpload();
		});
	});

	function ajaxFileUpload() {
		$.ajaxFileUpload({
			url : 'test',
			secureuri : false,
			fileElementId : 'myfile',
			dataType : 'text',
			success : function(data) {
				$("input:file").val("");
				$("#sp").html(data).css("color", "green");
			},
			error : function(data) {
				$("#sp").html(data).css("color", "red");
			}
		});
	}
</script>
<body>
	ajax
	<input id="myfile" type="file" name="myfile">
	<br>
	<input type="button" value="上传">
	<br>
	<span id="sp"></span>
</body>
</html>