package test.customer;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.AddProductDAO;
import test.ProductBean;
import test.ViewAllProductDAO;

@SuppressWarnings("serial")
@WebServlet("/viewcusproduct")
public class ViewProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession hs = req.getSession(false);
		if(hs == null ) {
			req.setAttribute("msg", "Your Session expired " );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
			
		}else {
			ArrayList<ProductBean> pbs = new ViewAllProductDAO().retrieve();
			
			if(pbs.size() == 0 ) {
				req.setAttribute("msg", "No Product available " );
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "showing products ....");
				hs.setAttribute("cpblist",pbs);
				
				req.getRequestDispatcher("cus/viewcproduct.jsp").forward(req, resp);
				
				
			}
			
		}
	
	
	
	}

}
