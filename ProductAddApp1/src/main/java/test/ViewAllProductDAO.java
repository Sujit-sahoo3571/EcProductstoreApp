package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllProductDAO {

	ArrayList<ProductBean> pbl = new ArrayList<>();
	
	public ArrayList<ProductBean> retrieve(){
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT55 ");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				ProductBean pb = new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				pbl.add(pb);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return pbl;
	}
	
}
