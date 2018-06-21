<%@page import="com.briup.dao.AmountProperties"%>
<%@page import="com.briup.bean.Publish"%>
<%@page import="com.briup.dao.PublishDao"%>
<%@page import="com.briup.bean.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.briup.bean.Catalog"%>
<%@page import="com.briup.dao.CatalogDao"%>
<%!CatalogDao dao = new CatalogDao();
	Catalog catalog = dao.findAllCatalog();
	ProductDao pDao = new ProductDao();
	PublishDao publishDao = new PublishDao();
	List<Product> lProducts;
	List<Publish> publishs;%>
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
<script type="text/javascript" src="js/publish.js"></script>
<body>
	<!--顶部-->
	<jsp:include page="include/roof.jsp"></jsp:include>
	<!--头部-->
	<jsp:include page="include/top.jsp"></jsp:include>
	<!--内容-->
	<div class="container4">
		<!--热卖-->
		<div class="c4_b1">
			<ul class="c4_b1_boxes">
				<%
					int amount = AmountProperties.getAmount();
					lProducts = pDao.sellerProduct(amount);
					for (Product product : lProducts) {
				%>
				<li><img src="<%=product.getImg()%>">
					<div class="c4_b1_box_txt">
						<p><%=product.getName()%></p>
						<h1>
							活动价：<b>￥<%=product.getHappy_price()%></b>
						</h1>
						<h2>立即抢购</h2>
					</div></li>
				<%
					}
				%>
			</ul>
		</div>
		<%
			String detail = request.getParameter("detail");
			String catalog = request.getParameter("catalog");
			String publish = request.getParameter("publish");
			String price = request.getParameter("price");
			String search = request.getParameter("search");
			String catalog_detail = detail;
			String catalog_copy = catalog;
			String detailAll = "";
			if (catalog == null) {
				catalog_copy = "书籍";
			}
			if (detail == null) {
				detailAll = "所有" + catalog_copy;
			}
		%>
		<div class="c4_b2">
			<h1 class="c4_b2_x">
				<a href="#"><%=catalog_copy%>&nbsp;&nbsp;></a> <span><a
					href="#"><%=detailAll%></a></span>
			</h1>

			<ul class="c4_b2_y">
				<%
					if (price != null) {
				%>
				<li><span class="search_key">价格：</span> <span
					class="search_val"><%=price%></span> <span class="search_del"
					onclick="delprice()"></span></li>
				<%
					}
					if (publish != null) {
				%>
				<li><span class="search_key">出版社：</span> <span
					class="search_val"><%=publish%></span> <span class="search_del"
					onclick="delpublish()"></span></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="c4_b3">
			<h1></h1>
			<div>
				<ul class="c4_b3_search">
					<li class="c4_b3_name">价格：</li>
					<li class="c4_b3_vals">
						<%
							String[] range = { "不限", "0-20", "21-50", "51-100", "101-200", "201-500", "501-1000", "1001-2000",
									"2000以上" };
							for (int i = 0; i < range.length; i++) {
								if(price!=null&&price.equals(range[i])){
						%> 
							<a style="cursor: pointer;color:red" onclick="price(<%=i%>)" name="price"><%=range[i]%></a>
						<%
								}else{ 
						%>
							<a style="cursor: pointer" onclick="price(<%=i%>)" name="price"><%=range[i]%></a>
						<%	
								}
							}
						%>
					</li>
				</ul>
				<ul class="c4_b3_search">
					<li class="c4_b3_name">出版社：</li>
					<li class="c4_b3_vals">
					<%
 						publishs = publishDao.findAllPublish();
 						int i = 1;
 						String[] pubRange = new String[7];
 						pubRange[0] = "不限";
 						pubRange[6] = "其他";
 						for (Publish pub : publishs) {
 							pubRange[i] = pub.getName();
 							if (i == 5) {
								break;
							}
							i++;
						}
 						for(int j = 0; j < pubRange.length; j++){
 							if(publish!=null&&publish.equals(pubRange[j])){
 					%>
					<a style="cursor: pointer;color: red" onclick="publish(<%=j %>)" name="publish"><%=pubRange[j] %></a> 
					<%			
							}else{
					%>
					<a style="cursor: pointer" onclick="publish(<%=j %>)" name="publish"><%=pubRange[j] %></a> 
					<%
							}
 						}
					%>
					</li>
				</ul>
			</div>
		</div>
		<%
			if ("" != search && search != null) {
				lProducts = pDao.findProductBySearch(search);
			} else if (("" != price && price != null) || ("" != publish && publish != null)) {
				if (("" != price && price != null) && ("" != publish && publish != null)) {
					if ("不限".equals(price) || "不限".equals(publish)) {
						if ("不限".equals(price) && "不限".equals(publish)) {
							if (catalog == null && detail == null) {
								lProducts = pDao.findAllProduct();
							} else if (detail != null) {
								lProducts = pDao.findProductByCatalogId(detail);
							} else {
								lProducts = pDao.findProductByCatalogName(catalog);
							}
						} else if (!"不限".equals(price)) {
							lProducts = pDao.findProductByPrice(price, catalog, detail);
						} else {
							if ("其他".equals(publish)) {
								lProducts = pDao.findProductByOther(catalog, detail);
							} else {
								lProducts = pDao.findProductByPublish(publish, catalog, detail);
							}
						}
					} else {
						lProducts = pDao.findProductByPriceAndPublish(publish, price, catalog, detail);
					}
				} else {
					if ("" != price && price != null) {
						if ("不限".equals(price)) {
							if (catalog == null && detail == null) {
								lProducts = pDao.findAllProduct();
							} else if (detail != null) {
								lProducts = pDao.findProductByCatalogId(detail);
							} else {
								lProducts = pDao.findProductByCatalogName(catalog);
							}
						} else {
							lProducts = pDao.findProductByPrice(price, catalog, detail);
						}
					} else if ("" != publish && publish != null) {
						if ("不限".equals(publish)) {
							if (catalog == null && detail == null) {
								lProducts = pDao.findAllProduct();
							} else if (detail != null) {
								lProducts = pDao.findProductByCatalogId(detail);
							} else {
								lProducts = pDao.findProductByCatalogName(catalog);
							}
						} else if ("其他".equals(publish)) {
							lProducts = pDao.findProductByOther(catalog, detail);
						} else {
							lProducts = pDao.findProductByPublish(publish, catalog, detail);
						}
					}
				}
			} else {
				if ("".equals(catalog) || catalog == null) {
					lProducts = pDao.findAllProduct();
				} else {
					if ("".equals(catalog_detail) || catalog_detail == null) {
						lProducts = pDao.findProductByCatalogName(catalog);
					} else {
						lProducts = pDao.findProductByCatalogId(detail);
					}
				}
			}
		%>
		<div class="c4_b4">
			<div class="c4_b4_x">
				<ul class="c4_b4_nav">
					<li id="this0" class="current"><a onclick="chance('<%="list.do" %>',0,'<%=catalog %>','<%=detail %>','<%=price %>','<%=publish %>','<%=search %>')" style="cursor: pointer;">默认</a></li>
					<li id="this1"><a onclick="chance('<%="list.do" %>',1,'<%=catalog %>','<%=detail %>','<%=price %>','<%=publish %>','<%=search %>')" style="cursor: pointer;">销量</a></li>
					<li id="this2"><a onclick="chance('<%="list.do" %>',2,'<%=catalog %>','<%=detail %>','<%=price %>','<%=publish %>','<%=search %>')" style="cursor: pointer;">价格</a></li>
					<li id="this3"><a onclick="chance('<%="list.do" %>',3,'<%=catalog %>','<%=detail %>','<%=price %>','<%=publish %>','<%=search %>')" style="cursor: pointer;">新品</a></li>
				</ul>
				<div class="c4_b4_search">
					<input type="text" /><span>确认</span>
				</div>
				<div class="c4_b4_pages"></div>
				<div class="clear"></div>
			</div>
			<div class="c4_b4_y">
				<ul>
					<li><input type="checkbox" onclick="show()"> 仅显示有货</li>
				</ul>
			</div>
		</div>
		<!--商品列表-->
		<div class="c4_b5">
			<div class="c4_b5_content">
				<ul class="c4_b5_c_boxes" id="val">
					<%
						for (Product product : lProducts) {
					%>
					<li class="c4_b5_c_box">
						<!--图片-->
						<div class="c4_b5_c_box_pic">
							<div class="c4b5_pic_view">
								<a
									href="viewBook.jsp?product_id=<%=product.getId()%>
                            &detail_id=<%=product.getCatalog_detail_id()%>
                            &catalog=<%=catalog%>"><img
									src="<%=product.getImg()%>"></a>
							</div>
						</div> <!--价钱-->
						<div class="c4_b5_c_box_txt">
							<h1>
								￥
								<%=product.getPrice()%></h1>
							<h2>
								<a
									href="viewBook.jsp?product_id=<%=product.getId()%>
                            &detail_id=<%=product.getCatalog_detail_id()%>
                            &catalog=<%=catalog%>">
									<%=product.getName()%></a>
							</h2>
						</div> <!--购买等操作-->
						<div class="c4b5_el">
							<div class="c4b5_el_x">
								<span class="wjx01"></span>
							</div>
						</div>
						<ul class="c4b5_option">
							<li class="shopcar_box"><span class="shopcar01"></span>加入购物车</li>
						</ul>
					</li>
					<%
						}
					%>
				</ul>
				<% 
					int pages = lProducts.size()/50;
					if(pages>=1){
				%>
						<div class="digg">
							<a class="disabled" onclick="into(0,'<%=pages %>')" id="cli" style="cursor: pointer;">&lt; </a> 
							<a class="current" href="#?page=1"
								onclick="init(0)" id="click0">1</a>
								<%
									for(int j=1;j<pages;j++){
										if(j>=10){}else{
								%>
								<a href="#?page=<%=j+1 %>"
								onclick="init('<%=j %>')" id="click0"><%=j+1 %></a>
								<% }}%>
							<a href="#?page=2" onclick="into(1,'<%=pages %>')" id="clic"> &gt; </a>
						</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<!--脚部-->
	<jsp:include page="include/bottom.jsp" flush="true"></jsp:include>

</body>
</html>