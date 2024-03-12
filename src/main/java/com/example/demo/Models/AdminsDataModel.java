package com.example.demo.Models;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "adminsrecord")
public class AdminsDataModel {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String adminName;
private String adminUserName;
private String adminEmail;
private String adminPassword;
private String adminRoles;
public AdminsDataModel(){
    this.adminRoles = "ADMIN";
}

public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getAdminRoles() {
	return adminRoles;
}
public void setAdminRoles(String adminRoles) {
	this.adminRoles = adminRoles;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminUserName() {
	return adminUserName;
}
public void setAdminUserName(String adminUserName) {
	this.adminUserName = adminUserName;
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

@Override
public String toString() {
	return "AdminsDataModel [Id=" + Id + ", adminName=" + adminName + ", adminUserName=" + adminUserName
			+ ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + ", adminRoles=" + adminRoles + "]";
}

}
