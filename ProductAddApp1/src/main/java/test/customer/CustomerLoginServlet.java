package test.customer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLoginServlet  extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession hs = req.getSession();
		
		CustomerBean cb = new CustomerDAO().getCus(req);
		
		if(cb == null ) {
			req.setAttribute("msg", "Invalid UserName and Password ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			hs.setAttribute("cbean", cb);
			req.setAttribute("msg", "Log In Success ");
			req.getRequestDispatcher("cus/loginsuccess.jsp").forward(req, resp);
		}
		
		
	}

}
