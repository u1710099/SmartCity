package com.idigital.epam.energy.entity;
public class AdminLogin {

	private String adminEmail;
	private String adminPassword;


	public AdminLogin() {
		super();

	}

	public AdminLogin(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


}
