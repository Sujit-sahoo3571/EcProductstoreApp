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
out.println(msg);
%>
<br>
<a href="addproduct.html">Add New Product </a><br>
<a href="viewproduct">View All Product </a><br>
<a href="logout">Log Out  </a><br>

</body>
</html>