package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			HttpSession hs = req.getSession(false);
			
			if(hs == null ) {
				req.setAttribute("msg", "Your Session Expired");
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
				
				int k = new AddProductDAO().addProduct(req);
				if(k > 0) {
					req.setAttribute("msg", "Product Added Successfully .... " );
					req.getRequestDispatcher("productadd.jsp").forward(req, resp);
				}else {
					req.setAttribute("msg", "Product Not added Properly ");
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				
				}
				
			}
			
	
	}
	

}
