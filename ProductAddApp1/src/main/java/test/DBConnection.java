package test;

import java.sql.Connection;
import java.sql.DriverManager;
import static test.DBInfo.*;

public class DBConnection {
	
	public static Connection con ; 
	
	private DBConnection() {
		
	}
	
	
	static {
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, user, pword);
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return con ; 
	}

}
