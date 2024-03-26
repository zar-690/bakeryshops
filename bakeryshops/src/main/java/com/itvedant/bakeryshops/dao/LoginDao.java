package com.itvedant.bakeryshops.dao;

public class LoginDao {

	private String email;
	private String Password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginDao [email=" + email + ", Password=" + Password + "]";
	}
	
	
}
