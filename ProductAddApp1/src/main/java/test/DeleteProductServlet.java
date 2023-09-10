package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession hs= req.getSession();
	
	try {
		
		if(hs == null ) {
			req.setAttribute("msg", "Your Session Ended " );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			
			ArrayList<ProductBean> pbs = (ArrayList<ProductBean>) hs.getAttribute("pblist");
			
			 	 Iterator<ProductBean> it = pbs.iterator();
			 	 
			 	 while(it.hasNext()) {
			 		 
			 		 ProductBean pb = (ProductBean) it.next();
			 		 if(pb.getPcode().equals(req.getParameter("pcode"))) {
			 			 
			 			 int k = new DeleteProductDAO().delete(pb);
			 			 
			 			 if(k > 0 ) {
			 				 req.setAttribute("msg", "Delete Successfully ..." );
			 				 req.getRequestDispatcher("deleteSuccess.jsp").forward(req, resp);
			 			 }else 
			 				 req.setAttribute("msg", "Something went wrong"+req.getParameter("pcode") );
			 			 req.getRequestDispatcher("home.jsp").forward(req, resp);
			 			 
			 			 break;
			 			 
			 		 }
			 		 
			 	 }
			 	 
			
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	}

}
