package test.customer;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.ProductBean;

@SuppressWarnings("serial")
@WebServlet("/cusbuy")
public class BuyProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg", "Your session Expired " );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			StringBuffer pbstring = new StringBuffer();
			ArrayList<ProductBean> pbs= AddedProductList.getProducts();
			if(pbs.size() ==0 ) {
				
			}else {
				final DecimalFormat df = new DecimalFormat("0.00");
				
				Iterator<ProductBean> it = pbs.iterator();
				double sum = 0;
				while(it.hasNext()) {
					ProductBean pb = it.next();
					pbstring.append( "Product Code : "+pb.getPcode() +" Product Name : "+ pb.getPname()+" Product Price : "+ pb.getPrice()+"\n");
					sum += pb.getPrice();
				}
			double	  deliverycharge =  (sum < 500) ? 50 :  0 ;
				  pbstring.append(" delivery charge: "+deliverycharge  );  
				
				if(sum < 500) sum += 50;
				
				System.out.println(pbstring);
				BuyProdBean bpb = new BuyProdBean();
				CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");
				// LocalDateTime
				LocalDateTime ldt =  LocalDateTime.now();
				System.out.print(ldt);
				bpb.setId(cb.getUname()+cb.getPword()+ldt);
				bpb.setProdlist(pbstring);
				bpb.setPrice(Double.parseDouble(df.format(sum)));
				
				int k = new BuyProductDAO().insetBuy(bpb);
				
			if(k > 0) {
				System.out.println("inserted successfully .... ");
				req.setAttribute("msg", "Ordered Completed ");
				AddedProductList.clear();
				req.getRequestDispatcher("orderpage.jsp").forward(req, resp);
				
				}		
						
			}
		
			
			
		}
	
	}

}
