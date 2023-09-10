package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.websocket.Session;

@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession hs = req.getSession(false);
			if(hs == null ) {
				req.setAttribute("msg", "Your Session Expired " );
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
				
				
				
				ArrayList<ProductBean> pbs = (ArrayList<ProductBean>) hs.getAttribute("pblist");
				Iterator<ProductBean> it   = pbs.iterator();
				int k=0;
				while(it.hasNext()) {
					ProductBean pb = (ProductBean) it.next();
					if(pb.getPcode().equals(req.getParameter("pcode"))) {

						pb.setPname(req.getParameter("pname"));
						pb.setPrice(Double.parseDouble(req.getParameter("pprice")));
						pb.setQty(Integer.parseInt(req.getParameter("pqty")));
						
						k =  new UpdateProductDAO().updateProduct(pb);
						if(k > 0) {
							req.setAttribute("msg", "Product Update Sucessfully ...");
							
						}else {
							req.setAttribute("msg", "Some thing went Wrong");
						}
						
						break; 
					}
				}
				
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				
				
			}
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
	}

}
