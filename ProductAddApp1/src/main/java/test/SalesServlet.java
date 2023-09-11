package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import test.customer.BuyProdBean;
@SuppressWarnings("serial")
@WebServlet("/viewsales")
public class SalesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg", "Your Session Expired ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else {
			
			ArrayList<BuyProdBean> al = new SalesDAO().getSales();
			if(al.size() == 0 ) {
				req.setAttribute("msg", "No Sale History available ");
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			
			}else {
				req.setAttribute("sales", al);
				req.getRequestDispatcher("sales.jsp").forward(req, resp);
			}
			
			
		}
		
	
	}
	

}
