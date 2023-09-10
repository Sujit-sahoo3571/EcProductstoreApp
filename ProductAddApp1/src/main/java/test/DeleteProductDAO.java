package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {

	int k  = 0 ;
	public int delete(ProductBean pb ) {
		
		Connection con = DBConnection.getCon();
		try{
			PreparedStatement ps = con.prepareStatement("delete product55 where code =? ");
			ps.setString(1, pb.getPcode());
			k = ps.executeUpdate();
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		return k; 
	}
	
	
}
