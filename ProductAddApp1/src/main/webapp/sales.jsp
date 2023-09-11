<%@page import="java.util.Iterator"%>
<%@page import="test.customer.BuyProdBean"%>
<%@page import="java.util.ArrayList"%>
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
out.println("<br> <h1> welcome to sales History </h1><br> ");
ArrayList<BuyProdBean> al = (ArrayList<BuyProdBean>) request.getAttribute("sales");
 
if(al == null ){
	out.println("No History Found <br>");
}else {
	Iterator<BuyProdBean> it = al.iterator();
	while(it.hasNext()){
		BuyProdBean bb = it.next();
		out.println("<Br> ID : "+ bb.getId()+ " <b> Product List </b> <br>: "+bb.getProdlist()+ " Total Price : "+bb.getPrice()+" <a href ='deletehistory?hid="+bb.getId()+"'> Delete </a> <br> <br>" );
		
	} 
}





%>

<br> <br>

<a href="addproduct.html">Add Product </a><br> 
<a href="viewproduct">View Product </a><br> 
<a href="logout">LogOut</a><br> 

</body>
</html>