<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>mail group sending system</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head> 
  <body>
   
   <!-- form  Start -->
    <form action="mail" method="post" >
        <p>收件人：<input type="text" name="m_name" /></p>
        <p>主题：<input type="text" name="m_topic" /></p>
        <p>正文：<textarea name="c_con" rows="" cols=""></textarea></p>
        <input type="submit" value="发送" />
    </form>
   <!--form  End  --> 
  </body>
</html>
