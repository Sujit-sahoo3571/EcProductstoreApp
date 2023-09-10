package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/editproduct")
public class EditProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		
		if(hs == null ) {
			req.setAttribute("msg", "YOUR Session Expired ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			
			String pcode = req.getParameter("pcode");
			
			ArrayList<ProductBean> pbs  = (ArrayList<ProductBean>) hs.getAttribute("pblist");
			
			Iterator<ProductBean> it = pbs.iterator();
			
			while(it.hasNext()) {
				
				ProductBean pb = (ProductBean) it.next();
				
				if(pb.getPcode().equals(pcode)) {
					req.setAttribute("pb", pb);
					break; 
				}
				
			}
			
			req.getRequestDispatcher("editproduct.jsp").forward(req, resp);
			
		}
		
		
	}
	

}
