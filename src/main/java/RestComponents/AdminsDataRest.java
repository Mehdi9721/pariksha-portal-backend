package RestComponents;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Models.AdminsDataModel;
import ServicesForRest.AdminsDataService;

@RestController("/api")
public class AdminsDataRest {
private AdminsDataService adminService;
@PostMapping("/admin")
public ResponseEntity<AdminsDataModel> adminSave(@RequestBody AdminsDataModel adminModel) {
	AdminsDataModel adminSaved=adminService.saveAdmin(adminModel);
	return ResponseEntity.ok(adminSaved);
	}
}
