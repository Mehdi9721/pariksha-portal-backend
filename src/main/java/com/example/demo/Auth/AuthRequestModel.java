package com.example.demo.Auth;

public class AuthRequestModel {

    private String adminEmail;
    private String adminPassword;
    
	public AuthRequestModel(String userEmail, String adminPassword) {
		super();
		this.adminEmail = userEmail;
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
