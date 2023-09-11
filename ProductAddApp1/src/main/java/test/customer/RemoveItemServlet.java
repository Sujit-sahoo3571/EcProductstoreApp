package test.customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.ProductBean;

@SuppressWarnings("serial")
@WebServlet("/removeitem")
public class RemoveItemServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg", "Your session Expired " );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			
			req.setAttribute("msg", "Removing Product ");
			ArrayList<ProductBean> pbs = AddedProductList.getProducts();
			Iterator<ProductBean> it = pbs.iterator();
			while(it.hasNext()) {
				ProductBean pb = it.next();
				if(pb.getPcode().equals(req.getParameter("pcode"))) {
					AddedProductList.removeProduct(pb);
					break;
					
				}
			}
			
			req.getRequestDispatcher("cartprod.jsp").forward(req, resp);
			
			
		}
		
		
		
		
		
	}

}
