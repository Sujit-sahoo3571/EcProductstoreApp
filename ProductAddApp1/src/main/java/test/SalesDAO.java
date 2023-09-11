package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test.customer.BuyProdBean;

public class SalesDAO {
	
	BuyProdBean bb = null ;
	ArrayList<BuyProdBean> al = new ArrayList<>();
	
	
	public ArrayList<BuyProdBean> getSales(){
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from buyprod55 " );
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bb = new BuyProdBean();
				bb.setId(rs.getString(1));
				bb.setProdlist(new StringBuffer(rs.getString(2)));
				bb.setPrice(rs.getDouble(3));
				al.add(bb);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al ; 
	}

}
