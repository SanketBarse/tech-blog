package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;

public class DuplicateUser {
	
	private  Connection con;
	private  ResultSet res;
	private  boolean ans;
	public DuplicateUser(Connection con) {
		this.con = con;
	}
	
	public  boolean isDuplicate(String email, String phone) {
		try {
			String query = "select user_email from user where user_phone="+phone; 
			Statement st = con.createStatement();
			res = st.executeQuery(query);	
			ans=res.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;	
	 
	}
	
}
