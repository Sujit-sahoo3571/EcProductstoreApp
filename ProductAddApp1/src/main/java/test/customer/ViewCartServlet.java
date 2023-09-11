package test.customer;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.ProductBean;
@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		if(hs == null ) {
			req.setAttribute("msg", "Your Session Expired" );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			ArrayList<ProductBean> al = AddedProductList.getProducts();
			
			if(al.size() == 0 ) {

				req.setAttribute("msg", "No Product is added " );
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "Your Total Product List " );
				req.getRequestDispatcher("cartprod.jsp").forward(req, resp);
			}
			
		}
	
	
	}

}
