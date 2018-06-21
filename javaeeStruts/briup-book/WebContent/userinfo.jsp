<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.briup.bean.User"%>
<%!
	User user;
%>
<%
	user = (User)session.getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup安全中心</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/newmain.css" />
</head>
<script type="text/javascript" src="js/userinfo.js">
</script>
<body>
	<!--顶部-->
	<jsp:include page="include/roof.jsp"></jsp:include>
    <!--头部-->
    <jsp:include page="include/top.jsp"></jsp:include>
    <div class="container4">
    	<div class="register_box">
    			<div class="head">
    				<h3>个人信息</h3>
    			</div>
    			<div class="security">
    					<ul class="list">
    						<li>
    								<input id="J_euserName" class="long" readonly="readonly" name="txtUser" value="<%=user.getName() %>" type="text"/>
    								<div class="name">用户名:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" class="long" name="txtUser" value="<%=user.getPass() %>" type="password" onchange="change()"/>
    								<span style="font-size: 10px;color: red" id="ps"></span>
    								<div class="name">密码:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" class="long" name="txtUser" value="<%=user.getPostcode() %>" type="text" onchange="change()" onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
    								<span style="font-size: 10px;color: blue" id="co"></span>
    								<div class="name">邮编:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" class="long" name="txtUser" value="<%=user.getAddress() %>" type="text" onchange="change()"/>
    								<span style="font-size: 10px;color: red" id="ad"></span>
    								<div class="name">地址:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" class="long" name="txtUser" value="<%=user.getPhone() %>" type="text" onchange="change()" onkeyup="this.value=this.value.replace(/[^\d]/ig,'')"/>
    								<span style="font-size: 10px;color: red" id="te"></span>
    								<div class="name">电话:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" class="long" name="txtUser" value="<%=user.getEmail() %>" type="text" onchange="change()"/>
    								<span style="font-size: 10px;color: blue" id="em"></span>
    								<div class="name">电子邮箱:</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						<li>
    								<input id="J_euserName" onclick="sub('userinfo.do')" class="long" style="width:70px;font-size: large;cursor: pointer;text-align: center;line-height: 40px;"  value="修改" type="submit" />
    								<div class="name">&nbsp;</div>
    								<span id="J_eUserNameTipImg" class="icon"></span>
    								<div id="J_eUserNameTipInfo" class="ltip"></div>
    								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
    						</li>
    						
    					</ul>
    			</div>
    	</div>
    </div>
 
    <!--脚部-->
    <jsp:include page="include/bottom.jsp" flush="true"></jsp:include>

</body>
</html>