<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12/31
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>
<body>
    你好:<%=request.getAttribute("loginUser") %>，现在时间是<%= new Date() %>
</body>
</html>
