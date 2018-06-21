<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.briup.bean.CatalogDetail"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.bean.Catalog"%>
<%@page import="com.briup.dao.CatalogDao"%>
<%! 
	CatalogDao dao = new CatalogDao();
	Catalog catalog = dao.findAllCatalog();
	List<CatalogDetail> lists;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
	<!--顶部-->
	<jsp:include page="include/roof.jsp"></jsp:include>
	<!--头部-->
	<jsp:include page="include/top.jsp"></jsp:include>
	<div class="container3">
		<div class="c3_b1">
			<div class="c3_b1_left">
				<dl>
					<%
						for (String str : catalog.getCatalogs()) {
							lists = dao.findCatalogDetailByName(str);
							int height=0;
							if(lists.size()%2==0){
								height = lists.size()/2;
							}else{
								height = lists.size()/2+1;
							}
					%>
					<!-- height变量动态设置dd的高度 -->
					<dd style="height:<%=height*17+55 %>px">
						<h1><%=str %></h1>
						<p>
						<%
							for(CatalogDetail detail:lists){
						%>
							<a href="list.jsp?catalog=<%=str %>&&detail=<%=detail.getName() %>"><%=detail.getName() %></a> 
						<% 
							}
						%>
						</p>
					</dd>
					<%
						}
					%>
				</dl>
			</div>
			<div class="c3_b1_center">
				<div>
					<a href="#"><img src="images/ad1.png"></a>
				</div>
				<div class="c3_b1_c_bottom">
					<ul>
						<li><a href="#"><img src="images/p01.png" /></a> <a href="#">Java从入门到精通</a>
						</li>
						<li><a href="#"><img src="images/p01.png" /></a> <a href="#">Java从入门到精通</a>
						</li>
						<li><a href="#"><img src="images/p01.png" /></a> <a href="#">Java从入门到精通</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="c3_b1_right">
				<h1>
					杰普快报<a href="#">更多</a>
				</h1>
				<ul>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
				</ul>
			</div>
			<div style="clear: both"></div>
		</div>
		<div class="c3_b2">
			<ul>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
			</ul>
		</div>
		<div class="c20"></div>
	</div>
	<!--脚部-->
	<jsp:include page="include/bottom.jsp" flush="true"></jsp:include>
</body>
</html>
