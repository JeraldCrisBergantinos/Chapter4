package com.mapua.sample;

public class AccessData {
	
	private String userID;
	private String password;
	private int ID;
	
	public AccessData(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}