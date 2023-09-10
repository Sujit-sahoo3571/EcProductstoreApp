<%@page import="test.AdminBean"%>
<%@page import="test.ProductBean"%>
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
ProductBean pb  = (ProductBean) request.getAttribute("pb");
AdminBean abean = (AdminBean) session.getAttribute("abean");

out.println("This page belongs to "+ abean.getFname()+" <br> ");


%>
<form action = "updateproduct" method ="post">
 <input type =hidden name ="pcode" value=<%=pb.getPcode() %> > <br>
Product Name : <input type ="text" name ="pname" value =<%=pb.getPname() %>> <br>
Product Price : <input type ="text" name ="pprice" value = <%=pb.getPrice() %>> <br>
Product Quantity : <input type ="text" name ="pqty"  value =<%=pb.getQty() %>> <br>
<input type ="submit" value ="Update">  
</form>
</body>
</html>