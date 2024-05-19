package com.example.demo.RestComponents;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Auth.AuthRequestModel;
import com.example.demo.Models.AdminsDataModel;
import com.example.demo.ServicesForRest.AdminsDataService;
import com.example.demo.ServicesForRest.JwtService;
import com.example.demo.jpaRepositories.AdminsDataRepository;

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
	int adEmail=adminService.findAdminByEamil(adminModel.getAdminEmail());
	if(adEmail==1) {
		AdminsDataModel adminUpdated=adminService.updateAdmin(adminModel);
		return ResponseEntity.ok(adminUpdated);
	}else {
		AdminsDataModel adminSaved=adminService.saveAdmin(adminModel);
		return ResponseEntity.ok(adminSaved);
	}
	
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

@Autowired
private AdminsDataRepository adminr;

@PutMapping("/adminLogin")
public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody AuthRequestModel authRequest) {
	 try {
		
		    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getAdminEmail(), authRequest.getAdminPassword()));
		    if (authentication.isAuthenticated()) {
		  	  String token = jwtService.generateToken(authRequest.getAdminEmail());
		  	  
		  Optional<AdminsDataModel> x= adminr.findByAdminEmail(authRequest.getAdminEmail());
		  String adminId = x.map(admin -> admin.getId().toString())
                  .orElse(null);
		  String adminName = x.map(admin -> admin.getAdminName())
                  .orElse(null);
		  String adminUserName = x.map(admin -> admin.getAdminUserName())
                  .orElse(null);
		  	 Map<String, String> responseMap = new HashMap<>();
	            responseMap.put("token", token);
	            responseMap.put("adminId", adminId);
	            responseMap.put("adminName", adminName);
	            responseMap.put("adminUserName", adminUserName);
	            return ResponseEntity.ok(responseMap);
		    } else {
		        throw new UsernameNotFoundException("invalid user request !");
		    }
		} catch (Exception e) {
		    e.printStackTrace(); 
		    throw e; 
		}

}
	
@GetMapping("/findAllAdmins")
public List<AdminsDataModel> allAdmins(){
	return adminr.findAll();
}

@DeleteMapping("/deleteAdmin/{id}")
public void deleteAdmin(@PathVariable("id") String id) {
	
	adminr.deleteAdminById(id);
}


}
