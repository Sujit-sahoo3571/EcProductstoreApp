package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.DBConnection;

public class RegisterAdminDAO {
	int k = 0;
	
	public int register( AdminBean ab ) {
		
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into admintab55 values ( ?, ?, ? ,  ? , ? , ? ,? )");
			ps.setString(1, ab.getUname());
			ps.setString(2, ab.getPword());
			ps.setString(3, ab.getFname());
			ps.setString(4, ab.getLname());
			ps.setString(5, ab.getAddr());
			ps.setString(6, ab.getMid());
			ps.setLong(7, ab.getPh());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return k; 
		
	}

}
