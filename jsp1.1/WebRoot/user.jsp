<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>three</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//设置该页面请求编码为utf-8
    	request.setCharacterEncoding("utf-8");
    	if(request.getParameter("str") != null && request.getParameter("str") != ""){
    		out.print(request.getParameter("str") + "，欢迎你！");
    	}
    	else{
    		out.print("请先登录！");
    %>
 			<a href="login.jsp">登录</a>
    <% }%>
  </body>
</html>
