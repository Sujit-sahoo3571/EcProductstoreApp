package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession hs = req.getSession(false);
		if(hs == null ) {
			req.setAttribute("msg", "Your Session Expired " );
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else {
			pw.println( "Logout Sucessfully <br> ");
			hs.removeAttribute("pblist");
			hs.removeAttribute("abean");
			hs.invalidate();
		
			req.getRequestDispatcher("Adminlogin.html").include(req, resp);
			
		}
		
	
	}

}
