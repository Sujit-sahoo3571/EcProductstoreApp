package test.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.DBConnection;

public class BuyProductDAO {
	
	int k ; 
	public int insetBuy(BuyProdBean bp) {
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO BUYPROD55 VALUES (? , ? , ? )" );
			ps.setString(1, bp.getId());
			ps.setString(2, new String(bp.getProdlist()));
			ps.setDouble(3, bp.getPrice());
			
			k = ps.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k; 
	}
	
	
}
