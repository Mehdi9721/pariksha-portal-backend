package com.example.demo.ServicesForRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.jpaRepositories.AdminsDataRepository;

@Service
public class AdminsDataService {
	@Autowired	
	private AdminsDataRepository adminrepo; 
	
	public AdminsDataModel saveAdmin(AdminsDataModel admin) {
		return adminrepo.save(admin);
		}
		public AdminsDataModel updateAdmin(AdminsDataModel admin) {
		return adminrepo.save(admin);
		}
		public void deleteAdminById(Long prn) {
			adminrepo.deleteById(prn);
		}
}
