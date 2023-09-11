package test.customer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/cusreg")
public class RegisterCustomerServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
		
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("uname"));
		cb.setPword(req.getParameter("pword"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setMid(req.getParameter("mid"));
		cb.setPh(Long.parseLong( req.getParameter("ph")));
	
		
		int k  = new RegisterCustomerDAO().register(cb);
		
		if(k > 0) {
			
			pw.print("<br> Register Success .... " );
			req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
		
		
		}else {
			req.setAttribute("msg", "Something went wrong ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);;
		
		}
		
	
	}

}
