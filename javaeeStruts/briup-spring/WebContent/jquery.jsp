<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jquery测试</title>
<script src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* console.log($ === jQuery);
		var $div = $("div");
		console.log($div);
		$("#id1")
		 //$div.each(function(i,o){
		//	console.log(i);
		//	console.log(o);
		//}); 
		$.each($("div"), function(d, o) {
			console.log(d);
			console.log(o);
		})
		//取值
		var val = $("div:first").attr("id");
		//设值
		$("div:first").attr("id", "");
		console.log(val);
		//properties:{key:value,key:value}
		var id = $("div:first").attr({
			"id" : "id2",
			"style" : "color:red"
		});
		console.log(id);
		var $span = $("<span name='aaa'>123</span>");
		//append表示追加到孩子节点的后面
		$("#id2").append($span);
		//如果追加的是页面中存在的标签，则会把存在的移动到追加的后面
		$(".in").append($("div:last"));
		//prepend追加到孩子节点的最前面
		$(".in").prepend($("div:last"));
		//min：表示内容为min的
		var $to = $(".to:contains('min')");
		$to.remove();
		$("div:not(0)").hover(function() {
			$(this).attr({"style":"color:red"});
		}, function() {
			$(this).css("color","blue");
			//$(this).attr("style","color:blue");
		}); */
		var $json = [ {
			"name" : "miner"
		}, {
			"name" : "me"
		}, {
			"name" : "son"
		} ];
		$.each($json, function(index, o) {
			console.log(o);
		});
		$.ajax({
			url : "MyServlet",
			type : "post",
			data : {
				"name" : "min"
			},
			success : function(data) {
				console.log(data);
			},
			dataType : "json"
		});
		$(".sub").hover(function() {
			$(this).html("傻逼哈哈");
		}, function() {
		});
		$(".sub").on("click", function() {
			var $id=$("#id2");
			$id.animate({left : 500}, 2000, "linear");
			$id.animate({top : 500,fontSize:"2em"}, 1000, "linear");
			$id.animate({left : 0,opacity:"0.3",fontSize:"1.5em"}, 2000, "linear");
			$id.animate({top : 200,opacity:"1",fontSize:"2em"}, 2000, "linear");
			$("#id1").css("color", "red");
		});
		$("#sh").on("click", function() {
			$("#hi").slideToggle("slow");
		});
	});
</script>
</head>
<body>
	<div id="id1" style="width: 50px">nihao</div>
	<br />
	<div class="in">1</div>
	<div>2</div>
	<div>3</div>
	<div>4</div>
	<div class="to">min</div>
	<button class="sub" name="sub">点击</button>
	<div id="id2"
		style="background: #98bf21; height: 100px; width: 100px; position: absolute;">nihao</div>
	<br />
	<div id="hi"
		style="display: none; height: 80px; margin: 0px; padding: 5px; text-align: center; background: #e5eecc; border: solid 1px #c3c3c3;">
		<p>隐藏内容</p>
	</div>
	<p id="sh"
		style="margin: 0px; padding: 5px; text-align: center; background: #e5eecc; border: solid 1px #c3c3c3;">显示</p>
</body>
</html>