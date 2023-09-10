package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/viewproduct")
public class ViewAllProductServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//	ArrayList<ProductBean> pb = new ArrayList<ProductBean>();
	
		HttpSession hs = req.getSession(false);
	if(hs == null ) {
		req.setAttribute("msg", "Your Session Expired " );
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	}else {
		ArrayList<ProductBean> pb = new ViewAllProductDAO().retrieve();
		if(pb.size() == 0 ) {
			req.setAttribute("msg", "No Product Available Yet! ");
			req.getRequestDispatcher("productadd.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg", "Retrieving Your Product Successfully.... ");
			hs.setAttribute("pblist", pb);
			req.getRequestDispatcher("viewproduct.jsp").forward(req, resp);
			
		}
	}
	
	
	}

}
