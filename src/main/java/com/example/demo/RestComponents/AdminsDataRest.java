package com.example.demo.RestComponents;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.ServicesForRest.AdminsDataService;

@RestController
@RequestMapping("/api")
public class AdminsDataRest {
	
@Autowired
private AdminsDataService adminService;
@PostMapping("/adminSignup")
public ResponseEntity<AdminsDataModel> adminSave(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminSaved=adminService.saveAdmin(adminModel);
	return ResponseEntity.ok(adminSaved);
	}
@PutMapping("/adminLogin")
public int adminLogin(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminAuth=adminService.findAdmin(adminModel);
<<<<<<< HEAD
	if(adminAuth==null) {
		return 0;
	}
	System.out.println(adminModel.getAdminPassword());
	System.out.println(adminAuth.getAdminPassword());
	if(!adminModel.getAdminPassword().equals(adminAuth.getAdminPassword())) {
		return 0;
	}
	
	return 1;
=======
	if(adminAuth!=null) {
		return 1;
	}
	return 0;
>>>>>>> 5f449b9 (Created REST API for Exam)
	}
}
