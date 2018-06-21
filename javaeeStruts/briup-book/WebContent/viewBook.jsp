<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.briup.bean.Product"%>
<%@page import="com.briup.bean.Catalog"%>
<%@page import="com.briup.dao.ProductDao"%>
<%@page import="com.briup.dao.CatalogDao"%>
<%! 
	CatalogDao dao = new CatalogDao();
	Catalog catalog = dao.findAllCatalog();
	ProductDao pDao = new ProductDao();
%>
<%
	Product product = pDao.findProductById(Integer.parseInt(request.getParameter("product_id").trim()));
	String catalog=request.getParameter("catalog");
	if("null".equals(catalog)){
		catalog = dao.findCatalogNameByDetailId(Integer.parseInt(request.getParameter("detail_id").trim()));
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<script type="text/javascript" src="js/viewBook.js">
</script>
<body>
	<!--顶部-->
	<jsp:include page="include/roof.jsp"></jsp:include>
    <!--头部-->
    <jsp:include page="include/top.jsp"></jsp:include>
    
	<div class="container5">
    	<div class="cn5_top">
            <div class="cn5_top_x center01">
            	<a class="font20" href="#"><%=catalog%></a> >
                <a href="#"><%=pDao.findCatalogDetailNameById(Integer.parseInt(request.getParameter("detail_id").trim())) %></a>
            </div>
            <div class="cn5_top_y center01">
            	<div class="cn5topy_1">
                	<div class="cn5topy_imgview">
                    	<img src="<%=product.getImg() %>"/>
                        <ul class="cn5topy_imglist">
                        	<li><a href="#"><img src="images/viewBook.png"></a></li>
                            <li class="current"><a href="#"><img src="<%=product.getImg() %>"></a></li>
                            <li><a href="#"><img src="images/viewBook.png"></a></li>
                            <li><a href="#"><img src="images/viewBook.png"></a></li>
                            <li><a href="#"><img src="images/viewBook.png"></a></li>
                        </ul>
                    </div>
                </div>
                <div class="cn5topy_2">
                	<h1 class="pro_title font15"><%=product.getName() %></h1>
                    <div class="pro_price">
                            <div class="pro_price_x">
                                <p> briup价：<b>￥<%=product.getPrice() %></b> <a href="#">(降价通知)</a></p>
                            </div>
                            
                    </div>
                    <div class="pro_ship">
                        <div>
                        	<div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                            <ul class="pro_service f1">
	                        	<%
	                        		String str = product.getService();
	                        		for(int i=0;i<str.length();i++){
	                        			switch(str.charAt(i)){
                        					case '1':
	                        	%>
                                <li class="service_fq">分期付款</li>
                                <%
                               	 			break;
	                        				case '2':
                                %>
                                <li class="service_myf">免运费</li>
                                <%
                                			break;
	                        				case '3':
                                %>
                                <li class="service_zt">自提</li>
                                <%
                                			break;
	                        				case '4':
                                %>
                                <li class="service_th">7天无理由退换货</li>
                                <%
                                			break;
                                		}
	                        		}
                                %>
                            </ul>
                        </div>
                    </div>
                    <div class="pro_selects">
                    	<div class="pro_select">
                        	<div class="pro_key pro_key_vertical fl">选择版本：</div>
                            <ul class="pro_select_vals">
                           		<%
	                        		String ver = product.getVersion();
	                        		for(int i=0;i<ver.length();i++){
	                        			switch(str.charAt(i)){
	                        				case '1':
	                        	%>
                                <li>精装版</li>
                                <%	
                                			break;
	                        				case '2':
                                %>
                                <li>简装版</li>
                                <%
                               			 	break;
	                        				case '3':
                                %>
                                <li>收藏版</li>
                                <%
                                			break;
                                		}
	                        		}
                                %>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="pro_buy">
                    	<div class="pro_buy_nums">
                        	<input type="text" value="1" id="count" name="count"/>
                            <dl>
                            	<dd onclick="add()">+</dd>
								<dd onclick="del()">-</dd>
                            </dl>
                        </div>
                        <div class="pro_addshop">
                        	<a href="javascript:void(0)" onclick="addShopCart('<%="viewBook.do" %>',
                        	'<%=product.getName() %>','<%=product.getId() %>')">加入购物车 </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    	<div class="c5_b2">
        	
            <div class="c5_b2_right">
            	<!--选项卡-->
            	<ul class="c5_b2_tabs">
                	<li>商品介绍</li>
                    <li class="current">规格参数</li>
                    <li>包装清单</li>
                    <li>商品评价</li>
                </ul>
                <!--内容-->
              	<div class="c5_b2_right_1 box">
                        <div class="introduce_item">
                          <ul>
                        	<li>商品名称：<%=product.getName() %></li>
                            <li>商品编号：100<%=product.getId() %></li>
                            <li class="fr"><a class="color_link1" href="#">更多参数>></a></li>
                          </ul>
                        </div>
               		</div>
                    <div class="intro_pics">
                    	<img class="intro_pic" src="<%=product.getImg() %>">
                    </div>
                </div>
                
                
            <div class="c5_b2_right">
              	<div class="c5_b2_right_2">
                    	<h1>正品行货</h1>
                        <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>
                        
                        <h1>全国联保</h1>
                        <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>
                        
                        <h1>正品行货</h1>
                        <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>
                        
                        <h1>全国联保</h1>
                        <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>
                        
            		</div> 
            </div>
            
            <!--左侧栏-->
            <div class="c5_b2_left_container">
                <div class="c5_b2_left box">
                    <h1>服务时间 早9：00~凌晨1：00</h1>
                    <p>
                    <a href="#">
                        <img class="callmebyqq" src="images/icon_qq_03.png"/>
                    </a>
                    </p>
                </div>
                
                <div class="c5_b2_left box">
                    <h1>其他种类</h1>
                    <dl>
                        <dd>文学类</dd>
                        <dd>漫画类</dd>
                        <dd>通书类</dd>
                    </dl>
                    <dl>
                        <dd>文学类</dd>
                        <dd>漫画类</dd>
                        <dd>通书类</dd>
                    </dl>
                </div>
            </div> 
        </div>
    </div>
    	
    <div class="c20"></div>
    <!--脚部-->
    <jsp:include page="include/bottom.jsp" flush="true"></jsp:include>
</body>
</html>
