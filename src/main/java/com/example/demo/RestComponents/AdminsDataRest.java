package com.example.demo.RestComponents;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Auth.AuthRequestModel;
import com.example.demo.Models.AdminsDataModel;
import com.example.demo.ServicesForRest.AdminsDataService;
import com.example.demo.ServicesForRest.JwtService;

@RestController
@RequestMapping("/api")
public class AdminsDataRest {
	
@Autowired
private AdminsDataService adminService;

@Autowired
private JwtService jwtService;

@Autowired
private AuthenticationManager authenticationManager;

@PostMapping("/adminSignup")
public ResponseEntity<AdminsDataModel> adminSave(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminSaved=adminService.saveAdmin(adminModel);
	return ResponseEntity.ok(adminSaved);
	}
@PutMapping("/adminLogi")
public ResponseEntity<String> adminLogin(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminAuth=adminService.findAdmin(adminModel);
	if(adminAuth==null) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}
	if(!adminModel.getAdminPassword().equals(adminAuth.getAdminPassword())) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}
	  String token = jwtService.generateToken(adminModel.getAdminEmail());
	   return ResponseEntity.ok("Login successful. Token: " + token);
	}
@PutMapping("/adminLogin")
public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequestModel authRequest) {
	 try {
		
		    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getAdminEmail(), authRequest.getAdminPassword()));
		    System.out.println("hello");
		    if (authentication.isAuthenticated()) {
		  	  String token = jwtService.generateToken(authRequest.getAdminEmail());
			   return ResponseEntity.ok(token);
		    } else {
		        throw new UsernameNotFoundException("invalid user request !");
		    }
		} catch (Exception e) {
		    e.printStackTrace(); 
		    throw e; 
		}

}
}
