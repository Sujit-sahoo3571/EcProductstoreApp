<%@page import="test.customer.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String msg = (String) request.getAttribute("msg");
CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
out.println(msg);
out.println("<br> This page belongs to "+cb.getUname());

%>

<a href="viewcusproduct" > View All Product</a><br>  


</body>
</html>