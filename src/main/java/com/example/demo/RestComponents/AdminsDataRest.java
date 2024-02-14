package com.example.demo.RestComponents;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.ServicesForRest.AdminsDataService;

@RestController("/api")
public class AdminsDataRest {
private AdminsDataService adminService;
@PostMapping("/admin")
public ResponseEntity<AdminsDataModel> adminSave(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminSaved=adminService.saveAdmin(adminModel);
	return ResponseEntity.ok(adminSaved);
	}
}
