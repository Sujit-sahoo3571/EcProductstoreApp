<%@page import="java.text.DecimalFormat"%>
<%@page import="test.customer.AddedProductList"%>
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

final DecimalFormat df = new DecimalFormat("0.00");

ArrayList<ProductBean> al = AddedProductList.getProducts(); //(ArrayList<ProductBean>) session.getAttribute("cartlist");

if(al.size() == 0 ){
	out.println("<br> NO Product Available !! ");
	
}else {

Iterator<ProductBean> it = al.iterator();

double sum = 0; 

while(it.hasNext()){
	ProductBean pb = it.next();
	sum += pb.getPrice();
	out.println("<br> Product Code : "+pb.getPcode() +" &nbsp &nbsp Product Name : "+ pb.getPname()+ "&nbsp &nbsp " 
	
			+ "Product Price : "+ pb.getPrice()+"&nbsp &nbsp <a href = 'removeitem?pcode="+pb.getPcode()+"'> Remove </a>");
	
	
	
}


out.println("<br> <br> <br> <b> Total product Price ==================> : Rs. "+ df.format(sum)  +"<b> <br> ");
double deliveryfee = 0.0;
if(sum <500.0){
	deliveryfee = 50.0;
	
}else{
	deliveryfee = 0;
}
	out.println("<Br> <br>  Delivery Fees : =======================>  Rs. "+ df.format(deliveryfee) +  (deliveryfee ==0 ? " (Free) ": "" ) +" <Br> " );
	
	double grandtotal = (sum+ deliveryfee);

	

	out.println("<br> <br> Grand Total amount payble is =============> : "+ df.format(grandtotal) );

	
	

	out.println("<Br> <BR> <a href ='cusbuy'> BUY </a> ");
	
}



%>


<br> <br> 

<a href="cuslogout"> Logout </a>



</body>
</html>