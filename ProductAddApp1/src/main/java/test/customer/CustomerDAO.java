package test.customer;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import test.DBConnection;

public class CustomerDAO {
	
	CustomerBean cb = null; 
	
	public CustomerBean getCus(HttpServletRequest req) {
		
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from custtab55 where UNAME = ? AND PWORD =? ");
			
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cb = new CustomerBean();
				cb.setUname(rs.getString(1));
				cb.setPword(rs.getString(2));
				cb.setFname(rs.getString(3));
				cb.setLname(rs.getString(4));
				
				cb.setAddr(rs.getString(5));
				cb.setMid(rs.getString(6));
				cb.setPh(rs.getLong(7));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		return cb; 
	}

}
