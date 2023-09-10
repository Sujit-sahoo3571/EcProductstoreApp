
<%@page import="test.AdminBean"%>
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
String msg = (String ) request.getAttribute("msg");
out.println(msg+ "<br> ");

AdminBean ab = (AdminBean) session.getAttribute("abean");
out.println("<br> welcome " + ab.getFname()+" &nbsp "+ ab.getLname()+" <br> ");

%>

<a href="addproduct.html">Add Product </a><br> 
<a href="viewproduct">View Product </a><br> 
<a href="logout">LogOut</a><br> 

</body>
</html>