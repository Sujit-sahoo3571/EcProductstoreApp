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
String msg = (String ) request.getAttribute("msg");

out.println(msg);
ArrayList<ProductBean> pbs = (ArrayList<ProductBean>) session.getAttribute("pblist");

if(pbs.size() == 0){
	out.println("No Product Available ");
}else {
	Iterator<ProductBean> it = pbs.iterator();
	while(it.hasNext()){
		 ProductBean pb =   (ProductBean) it.next() ;
		out.println( "<br> "+ pb.getPcode() + "&nbsp &nbsp"+ pb.getPname()
		+" &nbsp &nbsp"+ pb.getPrice() + "&nbsp &nbsp" + pb.getQty()
		+" &nbsp &nbsp " + "<a href = 'editproduct?pcode=" + pb.getPcode() +"'> Edit </a>"+
		"&nbsp &nbsp"+"<a href = ' deleteproduct?pcode="+pb.getPcode()+"' >Delete </a>"+ "<br>"
				);
		}
}

%>


<a href ="addproduct.html"> Add Product </a> <br>
<a href ="logout"> Log Out </a> <br>

</body>
</html>