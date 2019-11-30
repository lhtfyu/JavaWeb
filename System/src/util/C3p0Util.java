package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
	
	private static DataSource dataSource = new ComboPooledDataSource("test");
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
}
