<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="杰普软件(www.briup.com)" />
<meta name="description" content="杰普软件(www.briup.com)" />
<title>杰普――跑步社区</title>
<link rel="stylesheet" type="text/css" id="css" href="../style/main.css" />
<link rel="stylesheet" type="text/css" id="css" href="../style/style1.css" />
<script src="../js/main.js" type="text/javascript"></script>
</head>
<body>
<div id="btm">
<div id="main">

  <div id="header">
    <div id="top"></div>
    <div id="logo">
      <h1>跑步社区</h1></div>
    <div id="mainnav">
      <ul>
      <li><a href="../member/activity.html">首页</a></li>
      <li><a href="../other/musicrun.html">音乐跑不停</a></li>
      <li><a href="../other/equip.html">跑步装备库</a></li>
      <li><a href="../other/guide.html">专业跑步指南</a></li>
      <li><a href="../other/bbs.html">跑步论坛</a></li>
	 
      </ul>
      <span></span>
    </div>
   </div>
   
  <div id="tabsJ">
  <ul>
    <li><a href="sendInfo.html" title="Link 1"><span>写纸条</span></a></li>
    <li><a href="inbox.html" title="Link 2"><span>收件箱</span></a></li>
    <li><a href="outbox.html" title="Link 3"><span>发件箱</span></a></li>
  </ul>
</div>
<br /><br />

  <div id="content" align="center"> 
     <div id="center">
		<table border="0" style="margin-top:20px;" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="3">
						<table cellpadding="0" cellspacing="0" width="100%" height="62">
							<tr>
								<td width="309" valign="middle">
									<h3>
										发送讯息
									</h3>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="100%">
						<form name="sendInfoForm" action="../pages/messenger/sendMessage.do" method="post" onsubmit="return sendInfo(this);">
							<table bgcolor="#cccccc" border="0" style="margin:10px 0;" cellspacing="1" cellpadding="10"	align="center">
							<tr>
								<td bgcolor="#eeeeee" align="center" width="40%">
									收信人：
								</td>
								<td bgcolor="#ffffff" class="fontblue">
									<input type="text" name="receiver" style="width: 250;height: 25" value=""/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#eeeeee" align="center">
									主题：
								</td>
								<td bgcolor="#ffffff" class="fontblue">
									<input type="text" name="title" style="width: 350;height: 25" />
								</td>
							</tr>
							<tr>
								<td bgcolor="#eeeeee" align="center">
									消息内容：
								</td>
								<td bgcolor="#ffffff" class="fontblue">
									<textarea name="content" rows="8" cols="50"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center" bgcolor="#dddddd">
									<input type="submit" value="发送" />
									<input type="reset" value="重置" />
								</td>
							</tr>
							</table>
						</form>
					</td>
					
				</tr>
				<tr><td colspan="3" height="30"></td></tr>
			</table>
	        
        <div id="hots">
          <h2>我的地盘</h2>
          <ul>
          <li>
           <div>
            <img src="../images/a.gif" />
            <a href="../member/modify.html">基本信息</a>
            <p>可修改自己的基本信息</p>
           </div>
          </li>
          <li>
           <div>
            <img src="../images/b.gif" />
            <a href="inbox.html">我的信箱</a>
            <p>写信息、收件箱、发件箱</p>
           </div>
          </li>
          <li>
           <div>
            <img src="../images/c.gif" />
            <a href="buddyList.html">我的好友</a>
            <p>好友管理及黑名单</p>
           </div>
          </li>
          <li>
           <div>
            <img src="../images/d.gif" />
            <a href="../memberspace.html">个性空间</a>
            <p>创建自己的个性空间</p>
           </div>
          </li>
          </ul>
        </div> 
         
     </div>
     <div id="right">
       <h2>&nbsp;</h2>
      <ul><li></li>
      </ul>
     </div>
     <div class="clear"></div>
    
     
  </div>
  
  <div id="footer">
    <div id="copyright">
       <div id="copy">
       <p>CopyRight&copy;2013</p>
       <p>跑步社区(www.irun.com) </p>
        </div>
    </div>
    <div id="bgbottom"></div>
  </div>
  
</div>
</div>
</body>
</html>
