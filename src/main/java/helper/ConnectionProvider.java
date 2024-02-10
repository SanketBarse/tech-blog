
package helper;


import java.sql.*;

public class ConnectionProvider {
	
	private static Connection con;
	private static String url;
	private static String username;
	private static String password;
	
	
	public static Connection getConnection() {
		
		url = "jdbc:mysql://localhost:3306/techblog";
		username = "root";
		password = "ROOT";
		
		try {		
			if(con == null || con.isClosed()) {		
				Class.forName("com.mysql.cj.jdbc.Driver");			
				con = DriverManager.getConnection(url,username,password);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
