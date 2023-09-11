package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteHistoryDAO {

	int k ; 
	public int removeHistory(HttpServletRequest req) {
		
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from buyprod55 where prodid= ? ");
			ps.setString(1, req.getParameter("hid"));
			k = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k; 
	}
	
}
