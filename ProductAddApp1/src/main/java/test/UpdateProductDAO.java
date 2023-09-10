package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {

	int k = 0; 
	public int updateProduct(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update PRODUCT55 SET NAME = ?  ,PRICE = ? , QTY =? WHERE CODE = ? " );
			
			
			ps.setString(1, pb.getPname());
			ps.setDouble(2, pb.getPrice());
			ps.setInt(3, pb.getQty());
			ps.setString(4, pb.getPcode());
	
			k = ps.executeUpdate();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		return k ; 
	}
	
	
}
