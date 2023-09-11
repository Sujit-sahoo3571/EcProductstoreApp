<%@page import="java.util.Iterator"%>
<%@page import="test.ProductBean"%>
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
String msg = (String) request.getAttribute("msg");
out.println(msg);

ArrayList<ProductBean> pbs = (ArrayList<ProductBean> ) session.getAttribute("cpblist");

Iterator<ProductBean> it = pbs.iterator();

while(it.hasNext()){
	ProductBean pb= (ProductBean) it.next();
	out.println("<br> "+pb.getPcode() + " &nbsp &nbsp"+ pb.getPname()
	+ " &nbsp &nbsp "+ pb.getPrice() + " &nbsp &nbsp "+ pb.getQty()
	+ "<a href ='addcproduct?pcode="+pb.getPcode()+"'>  &nbsp; &nbsp; Purchase </a> <br>"
			
			);
	
}


%>
<br> 
<a href="viewcart"> Go To Cart </a> <br>

<a href="cuslogout"> Logout </a>

</body>
</html>