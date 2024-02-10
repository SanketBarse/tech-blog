package dao;

import java.sql.*;
import entity.User;

public class UserDao {

	private Connection con;
	private String query;
	private User user;
	
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	
	public void saveUser(User user) {
		
		try {
			query = "insert into user(user_email,user_phone,user_password,user_gender) values(?,?,?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, user.getUser_email());
			pstmt.setString(2, user.getUser_phone());
			pstmt.setString(3, user.getUser_password());
			pstmt.setString(4, user.getGender());
			
			pstmt.executeUpdate
			();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByEmailandPassword(String email, String pass) {
		
		try{
			query = "select * from user where user_email=? and user_password=?";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUser_email(rset.getString("user_email"));
				user.setUser_password(rset.getString("user_password"));
				user.setGender(rset.getString("user_gender"));
				user.setUser_phone(rset.getString("user_phone"));
			}else {
				System.out.println("you are not register with techblog..");
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
}
