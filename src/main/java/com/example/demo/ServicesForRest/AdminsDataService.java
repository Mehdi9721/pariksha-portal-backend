package com.example.demo.ServicesForRest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.jpaRepositories.AdminsDataRepository;

@Service
public class AdminsDataService {
	@Autowired	
	private AdminsDataRepository adminrepo; 
	
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	
	public AdminsDataModel saveAdmin(AdminsDataModel admin) {
		  admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));       
		  return adminrepo.save(admin);
		}
	
	public AdminsDataModel findAdmin(AdminsDataModel admin) {
		return adminrepo.findByAdminUserNameOrAdminEmail(admin.getAdminUserName(), admin.getAdminEmail());
	}
	public int findAdminByEamil(String adminEmail) {
		Optional<AdminsDataModel> adEmail=adminrepo.findByAdminEmail(adminEmail);
		if(adEmail.isPresent()) {
			return 1;
		}
		return 0;
	}
	public AdminsDataModel updateAdmin(AdminsDataModel admin) {
		  admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));  
		  adminrepo.updateAdmin(admin.getAdminName(),admin.getAdminUserName(),admin.getAdminEmail(),admin.getAdminPassword());
		  return admin;
		}
}
