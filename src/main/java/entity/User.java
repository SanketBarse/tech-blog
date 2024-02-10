package entity;

import java.sql.Timestamp;

public class User {
	
	
	private int id;
	private String user_email;
	private String user_phone;
	private String user_password;
	private String gender;
	private Timestamp dateTime;
	
	public User() {
		
	}

	public User(int id, String user_email, String user_phone, String user_password, String gender, Timestamp dateTime) {
		super();
		this.id = id;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_password = user_password;
		this.gender = gender;
		this.dateTime = dateTime;
	}

	public User(String user_email, String user_phone, String user_password, String gender) {
		super();
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_password = user_password;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	
	
	
	
}
