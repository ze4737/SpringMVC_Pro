<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/5
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.Exception"%>
<html>
<head>
    <title></title>
</head>
<body>
  <h1>Sorry! This is Error Page!</h1>
  <%
    Exception e = (Exception)request.getAttribute("exception");
    out.print(e.getMessage());
  %>
</body>
</html>
