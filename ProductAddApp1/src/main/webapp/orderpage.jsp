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
String msg= (String ) request.getAttribute("msg");
out.print(msg);

%>


<br> <br> <a href="viewcusproduct" > View All Product</a><br>  <br> 
<a href="cuslogout"> Logout </a>

</body>
</html>