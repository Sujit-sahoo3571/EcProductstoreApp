package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/deletehistory")
public class DeleteHistoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession hs= req.getSession();
		
		if(hs == null ) {
			req.setAttribute("msg", "Your session Expired ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else {
			int k = new DeleteHistoryDAO().removeHistory(req);
			if(k> 0) {
				PrintWriter pw= resp.getWriter();
				pw.print("deleted history..... ");
				req.getRequestDispatcher("viewsales").forward(req, resp);;
			}
		}
		
	
	}
}
