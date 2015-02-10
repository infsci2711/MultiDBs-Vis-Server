package edu.pitt.sis.infsci2711.multidbs.vis.test.account;

public class accountTestDBModel {
	private String UserName;
	private String Pin;
	
	public accountTestDBModel() {
		
	}
	
	public accountTestDBModel(final String UserName, final String Pin) {
		this.setUserName(UserName);
		this.setPin(Pin);
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(final String UserName) {
		this.UserName = UserName;
	}
	
	public String getPin() {
		return Pin;
	}

	public void setPin(final String Pin) {
		this.Pin = Pin;
	}
}
