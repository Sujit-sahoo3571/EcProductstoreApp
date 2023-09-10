package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/alogin")
public class AdminLoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		AdminBean ab = new AdminLoginDAO().userLogIn(req);
		
		if(ab == null ) {
			req.setAttribute("msg", "Invalid User Name and Password ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			HttpSession hs = req.getSession(); 
			hs.setAttribute("abean", ab);
			req.setAttribute("msg", "Login Success Welcome to this page" );
			req.getRequestDispatcher("adminloginSuccess.jsp").forward(req, resp);
			
		}
	
	
	}

}
