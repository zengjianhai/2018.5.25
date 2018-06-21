<%@page import="com.briup.dao.CatalogDao"%>
<%@page import="com.briup.dao.ProductDao"%>
<%@page import="com.briup.dao.ShopDao"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.bean.ShopProduct"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%!
	List<ShopProduct> lists;
	ShopDao sDao = new ShopDao();
	ProductDao pDao = new ProductDao();
	CatalogDao cDao = new CatalogDao();
%>
<%
	lists = sDao.findShopByGether(request.getParameter("pros"), request.getParameter("amount"));
%>
					<%
    					for(ShopProduct sProduct:lists){
    						String detail = pDao.findCatalogDetailNameById(sProduct.getProduct().getCatalog_detail_id());
    						String catalog = cDao.findCatalogNameByDetailId(sProduct.getProduct().getCatalog_detail_id());
    				%>
					<ul class="oneUL">
    					<li>
    						<img src="<%=sProduct.getProduct().getImg() %>" class="pic">
    						<p class="proname"><%=catalog %>&nbsp;&nbsp;<%=detail %>&nbsp;&nbsp;<font title="<%=sProduct.getProduct().getName() %>" style="color:blue"><%=sProduct.getProduct().getName() %></font>&nbsp;&nbsp;</p>
    						<p><font>¥<%=sProduct.getProduct().getPrice() %>.00</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×<%=sProduct.getAmount() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货</p>
    						<p><img src="images/sureLogo_14.png" alt=""><span>七天无理由退换货</span></p>
    					</li>
    					<li><pre>【赠品】  高级定制干花书签  随机  ×1</pre></li>
					</ul>
					<%
    					}
					%>