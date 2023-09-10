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
		HttpSession hs = req.getSession(false);
		if(hs == null ) {
			req.setAttribute("msg", "Your Session Expired " );
			
		}else {
			hs.removeAttribute("pblist");
			hs.removeAttribute("abean");
			hs.invalidate();
			req.setAttribute("msg", "Logout Sucessfully <br> ");
		}
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	
	}

}
