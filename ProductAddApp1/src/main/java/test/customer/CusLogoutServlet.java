package test.customer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/cuslogout")
public class CusLogoutServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
	
	resp.setContentType("text/html");
	
	HttpSession hs = req.getSession(false);
	if(hs == null ) {
		req.setAttribute("msg", "Your Session expired " );
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}else {
		pw.println("Logout successfully ..... <br>" );
		hs.removeAttribute("cbean");
		hs.removeAttribute("cpblist");
		hs.invalidate();
		req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
	
	}
	
	
	
	
	
	}

}
