package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLutil {
	
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String userName="root";
	private static final String password="19990525";
	private static final String url="jdbc:mysql://localhost:3306/System";
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
				Class.forName(driverName);
			 conn=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
