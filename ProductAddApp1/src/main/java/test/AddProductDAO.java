package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AddProductDAO {

	public int k  =0 ; 
	public int addProduct(HttpServletRequest req) {
	
		Connection con = DBConnection.getCon();
		try{
			PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCT55 VALUES (?,?,?,? ) ");
			ps.setString(1, req.getParameter("pcode"));
			ps.setString(2, req.getParameter("pname"));
			ps.setDouble(3, Double.parseDouble(req.getParameter("pprice")));
			ps.setInt(4, Integer.parseInt(req.getParameter("pqty")));
			 k = ps.executeUpdate();
			
		
		
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		return k; 
	}
	
	
}
