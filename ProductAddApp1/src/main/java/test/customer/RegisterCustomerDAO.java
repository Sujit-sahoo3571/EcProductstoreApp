package test.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.DBConnection;

public class RegisterCustomerDAO {
	int k = 0;
	
	public int register( CustomerBean cb ) {
		
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into custtab55 values ( ?, ?, ? ,  ? , ? , ? ,? )");
			ps.setString(1, cb.getUname());
			ps.setString(2, cb.getPword());
			ps.setString(3, cb.getFname());
			ps.setString(4, cb.getLname());
			ps.setString(5, cb.getAddr());
			ps.setString(6, cb.getMid());
			ps.setLong(7, cb.getPh());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return k; 
		
	}

}
