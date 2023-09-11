package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/adminreg")
public class RegisterAdminServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
		
		AdminBean ab = new AdminBean();
		ab.setUname(req.getParameter("uname"));
		ab.setPword(req.getParameter("pword"));
		ab.setFname(req.getParameter("fname"));
		ab.setLname(req.getParameter("lname"));
		ab.setAddr(req.getParameter("addr"));
		ab.setMid(req.getParameter("mid"));
		ab.setPh(Long.parseLong( req.getParameter("ph")));
	
		
		int k  = new RegisterAdminDAO().register(ab);
		
		if(k > 0) {
			
			pw.print("<br> Register Success .... " );
			req.getRequestDispatcher("Adminlogin.html").include(req, resp);
		
		
		}else {
			req.setAttribute("msg", "Something went wrong ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);;
		
		}
		
	
	}

}
