<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#li1:hover #C {
	display: block;
}

#li1 {
	position: relative;
	display: inline-block;
}

#C {
	display: none;
	position: absolute;
	width: 100%;
	background: #f9f9f9;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0, 2) z-index:1;
}

DIV.digg {
	PADDING-RIGHT: 3px;
	PADDING-LEFT: 3px;
	PADDING-BOTTOM: 3px;
	MARGIN: 3px;
	PADDING-TOP: 3px;
	TEXT-ALIGN: center
}

DIV.digg A {
	BORDER-RIGHT: #aaaadd 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #aaaadd 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	MARGIN: 2px;
	BORDER-LEFT: #aaaadd 1px solid;
	COLOR: #000099;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #aaaadd 1px solid;
	TEXT-DECORATION: none
}

DIV.digg A:hover {
	BORDER-RIGHT: #ee4e4e 1px solid;
	BORDER-TOP: #ee4e4e 1px solid;
	BORDER-LEFT: #ee4e4e 1px solid;
	COLOR: #000;
	BORDER-BOTTOM: #ee4e4e 1px solid
}

DIV.digg A:active {
	BORDER-RIGHT: #ee4e4e 1px solid;
	BORDER-TOP: #ee4e4e 1px solid;
	BORDER-LEFT: #ee4e4e 1px solid;
	COLOR: #000;
	BORDER-BOTTOM: #ee4e4e 1px solid
}

DIV.digg a.current {
	BORDER-RIGHT: #ee4e4e 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #ee4e4e 1px solid;
	PADDING-LEFT: 5px;
	FONT-WEIGHT: bold;
	PADDING-BOTTOM: 2px;
	MARGIN: 2px;
	BORDER-LEFT: #ee4e4e 1px solid;
	COLOR: #fff;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #ee4e4e 1px solid;
	BACKGROUND-COLOR: #ee4e4e
}

DIV.digg a.disabled {
	BORDER-RIGHT: #eee 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #eee 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	MARGIN: 2px;
	BORDER-LEFT: #eee 1px solid;
	COLOR: #ddd;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #eee 1px solid
}
</style>
</head>
<script type="text/javascript">
	var ajax = {};
	//第一步得到new XMLHttpRequest()对象
	ajax.x = function() {
		/*if (window.XMLHttpRequest)也可以*/
		if (typeof window.XMLHttpRequest != 'undefined') {
			return new XMLHttpRequest();
		}
		var versions = [ "MSXML2.XmlHttp.6.0", "MSXML2.XmlHttp.5.0",
				"MSXML2.XmlHttp.4.0", "MSXML2.XmlHttp.3.0",
				"MSXML2.XmlHttp.2.0", "Microsoft.XmlHttp" ];
		var xhr;
		for (var i = 0; i < versions.length; i++) {
			try {
				xhr = new ActiveObject(versions[i]);
				break;
			} catch (e) {
			}
		}
		return xhr;
	};
	//第二开启连接
	//第三发送数据
	//第四接收数据
	//完成
	ajax.send = function(url, method, data, success, fail, async) {
		if (async == 'undefined' || "" == async || async == null) {
			async = true;
		} else {
			async = false;
		}
		var x = ajax.x();
		/*为了规范和跨浏览器兼容性，放在open之前*/
		x.onreadystatechange = function() {
			if (x.readyState == 4) {
				var status = x.status;
				if (status >= 200 && status < 300) {
					success && success(x.responseText, x.responseXML);
				} else {
					fail && fail(status);
				}
				alert(x.readyState);
			}
		};
		x.open(method, url, async);
		if (method == 'POST') {
			x.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
		}
		x.send(data);
	};
	/*get请求*/
	ajax.get = function(url, data, fail, async) {
		var query = [];
		for ( var key in data) {
			query.push(encodeURIComponent(key) + '='
					+ encodeURIComponent(data[key]));
		}
		/*query.join('&'):     name=tom&password=123*/
		/*getUrl:     new.do?name=tom&password=123*/
		var getUrl = url + (query.length ? '?' + query.join('&') : '');
		success = function(response, xml) {
			var first = document.getElementById("first");
			first.value = response;
			alert(first.value + ":" + xml + " this is get");
		};
		ajax.send('new.do?name=tom&password=123', 'GET', null, success, fail,
				async);
	};
	/*post请求
	把对象数据用encodeURIComponent接收
	 */
	ajax.post = function(url, data, fail, async) {
		var query = [];
		for ( var key in data) {
			query.push(encodeURIComponent(key) + '='
					+ encodeURIComponent(data[key]));
		}
		success = function(response, xml) {
			alert(response + ":" + xml + " this is post")
		};
		ajax.send(url, 'POST', query.join('&'), success, fail, async);
	};
	/*
	以对象形式传递数据{name:'tom',password:123}
	 */
	function add(url, data, async) {
		fail = function(status) {
			alert(status);
		};
		ajax.post(url, {
			name : 'tom',
			password : 123
		}, fail, async);
	}
	function flush() {
		var url = location.href;
		var times = url.split("?");
		if (times[1] != 1)
			url += "?1";
		self.location.replace(url);
		alert(url);
	}
	var tar = 0;
	function init(i, pag) {
		var pages=parseInt(pag);
		var max = 0;
		if (pages > 10) {
			max = 9;
		} else {
			max = pages - 1;
		}
		for (var j = 0; j <= max; j++) {
			if (i == j) {
				document.getElementById("click" + j).className = "current";
				if(pages<=10&&j==max){
					document.getElementById("clic").className = "disabled";
				}else{
					document.getElementById("clic").className = "";
				}
				tar = j;
			} else {
				document.getElementById("click" + j).className = "";
			}
		}
		if (i == max && max == 9) {
			var v = document.getElementById("click" + i);
			var va = parseInt(v.innerHTML);
			for (var j = 0; j < max + 1; j++) {
				if (pages >= parseInt(v.innerHTML) + 5) {
					document.getElementById("click" + j).innerHTML = (parseInt(v.innerHTML) - (max - j)) + 5;
					if (j == 4) {
						document.getElementById("click" + j).className = "current";
						tar = j;
					}
				} else {
					document.getElementById("click" + j).innerHTML = pages - (9-j);
					if (j == 9 -( pages - parseInt(v.innerHTML))) {
						document.getElementById("click" + j).className = "current";
						tar = j;
					}
				}
			}
			if(pages==va){}else{
			document.getElementById("click" + i).className = "";}
		}
		if (i >= 1) {
			document.getElementById("cli").className = "";
		}
	}
	function into(i, pag) {
		var max = 0;
		var pages=parseInt(pag);
		if (pages > 10) {
			max = 9;
		} else {
			max = pages - 1;
		}
		var v = document.getElementById("click0");
		var x = parseInt(v.innerHTML);
		if (i == 0) {
			if (tar == 0) {
				if (x == 1) {
					document.getElementById("cli").className = "disabled";
					alert("this");
				} else {
					for (var j = 0; j <= max; j++) {
						document.getElementById("click" + j).innerHTML = x + j
								- 1;
						if (j == 0) {
							document.getElementById("click" + j).className = "current";
						} else {
							document.getElementById("click" + j).className = "";
						}
						if (document.getElementById("click0").innerHTML == 1) {
							document.getElementById("cli").className = "disabled";
						}
					}
				}
			} else {
				for (var j = 0; j <= max; j++) {
					if (j + 1 == tar) {
						tar--;
						document.getElementById("click" + j).className = "current";
						if (tar == 0 && x == 1) {
							document.getElementById("cli").className = "disabled";
						}
					} else {
						document.getElementById("click" + j).className = "";
					}
				}
			}
		} else {
			var biao;
			for (var j = 0; j <= max; j++) {
				if (document.getElementById("click" + j).className == "current") {
					biao = j;
				}
			}
			if (biao == 9) {
				var n = document.getElementById("click9");
				var y = parseInt(n.innerHTML);
				if (pages > y) {
					for (var j = 0; j <= max; j++) {
						document.getElementById("click" + j).innerHTML = y - 9
								+ j + 1;
						if (j == 9) {
							document.getElementById("click" + j).className = "current";
						} else {
							document.getElementById("click" + j).className = "";
						}
					}
				} else {
				}
			} else {
				for (var j = 0; j <= max; j++) {
					if (biao + 1 == j) {
						document.getElementById("click" + j).className = "current";
						tar++;
					} else {
						document.getElementById("click" + j).className = "";
					}
				}
			}
			if (biao >= 0) {
				document.getElementById("cli").className = "";
			}
		}
	}
</script>
<body>
	<div class="pro_buy_nums">
		<input type="text" value="1" id="count"
			onchange="add('<%="new.do"%>','','')" /> <a
			href="new.do?name=tom&password=123">tiaozhuan</a>
		<dl>
			<dd onclick="add()">+</dd>
			<dd onclick="del()">-</dd>
		</dl>
		<ul>
			<li id="li1"><a onclick="flush()">1</a>
				<div id="C" class="D">
					<a>2</a> <a>3</a> <a>4</a> <a>5</a> <a>6</a>
				</div></li>
		</ul>
	</div>
	<div
		style="width: 50px; height: 50px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap"
		id="first">的水电费水电费斯蒂芬斯蒂芬</div>
	<div class="pro_addshop">加入购物车</div>
	<%
		int pages = 15;
		if (pages > 1) {
	%>
	<div class="digg">
		<a class="disabled" onclick="into(0,'<%=pages%>')" id="cli"
			style="cursor: pointer;">&lt; </a> <a class="current" href="#page=1"
			onclick="init(0,'<%=pages%>')" id="click0">1</a>
		<%
			for (int j = 1; j < pages; j++) {
					if (j >= 10) {
					} else {
		%>
		<a href="#page=<%=j + 1%>" onclick="init('<%=j%>','<%=pages%>')"
			id="click<%=j%>"><%=j + 1%></a>
		<%
			}
				}
		%>
		<a href="#?page=2" onclick="into(1,'<%=pages%>')" id="clic"> &gt;
		</a>
	</div>
	<%
		}
	%>
</body>
</html>