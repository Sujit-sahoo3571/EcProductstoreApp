package test.customer;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.ProductBean;
import test.ViewAllProductDAO;

@SuppressWarnings("serial")
@WebServlet("/addcproduct")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg", "Your session Expired" );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else {
			
			ArrayList<ProductBean> pbs = new ViewAllProductDAO().retrieve();
			
			if(pbs.size() == 0) {
				req.setAttribute("msg", "No Product Available " );
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			
			}else {
				
				Iterator<ProductBean> it = pbs.iterator();
				
				while(it.hasNext()) {
					ProductBean pb = (ProductBean) it.next();
					if(pb.getPcode().equals(req.getParameter("pcode"))) {
						AddedProductList.addProduct(pb);
						req.setAttribute("msg", "Product Added Successfully");
						req.getRequestDispatcher("cus/viewcproduct.jsp").forward(req, resp);		
						
						break;
					}
				}
				
				
			}
			
			
		}
		
	
	}	
	
	
	
	
}
