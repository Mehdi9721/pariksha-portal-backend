package com.example.demo.RestComponents;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
>>>>>>> 6a397e9 (Created create exam REST API)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Models.StudentModel;
import com.example.demo.ServicesForRest.StudentService;

@RestController
@RequestMapping("/api")
public class StudentsRest {
	
	
	@Autowired
	private StudentService studentservice;	


	@PostMapping("/saveStudent")
	public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel Student){
		System.out.println("saveStudent url");
		//yhan pe student ka prn model se nikalo student.studentPrn, phir check kro prn hai ya nhi agr hai to int set kro nhi to 0
		Boolean check=true;
		
		if(check) {
			StudentModel studSave=studentservice.saveStudent(Student);
			return ResponseEntity.ok(studSave);
		}
		 return ResponseEntity.notFound().build();
	}
	

	@GetMapping("/getAllStudent")
	public  ResponseEntity<List<StudentModel>> getAllStudent(){
		  List<StudentModel> students = studentservice.getAllStudents();
	        return ResponseEntity.ok(students);
	}
<<<<<<< HEAD
	@PutMapping("/updateStudent")
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel Student){
		 studentservice.updateStudent(Student);
	        return ResponseEntity.ok(Student);
	}
	@DeleteMapping("/delete")
	 public ResponseEntity<String> deleteStudent(@RequestBody StudentModel Student) {
		studentservice.deleteStudentByPrn(Student.getStudentPrn());
  return ResponseEntity.ok("Student with PRN " + Student.getStudentName() + " deleted successfully.");
  
}
	@GetMapping("/getStudentByPrn/{prn}")
	 public ResponseEntity<StudentModel> getStudentByPrn(@PathVariable() String prn ) {
		StudentModel studentValid=studentservice.findStudentbyPrn(prn);
		if (studentValid != null) {
	        return ResponseEntity.ok(studentValid);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@DeleteMapping("/deleteAll")
	 public ResponseEntity<String> deleteAllStudents() {
		studentservice.deleteAllStudents();
 return ResponseEntity.ok("All students are deleted successfully.");
 
}
	 @PostMapping("/upload")
	    public String uploadFile(@RequestParam("file") MultipartFile file) {
	       studentservice.processAndSaveFile(file);
		 return "File uploaded successfully";
	    }
=======
	
	@GetMapping("/getStudentByPrn/{prn}")
	public ResponseEntity<StudentModel> getStudentByPrn(@PathVariable String prn) {
	    Optional<StudentModel> student = studentservice.getStudentByPrn(prn);
	    if (student.isPresent()) {
	        return ResponseEntity.ok(student.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

//	@PutMapping("/updateStudent")
//	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel Student){
//		  try {
//	            studentservice.updateStudent(Student);
//	            return ResponseEntity.noContent().build(); 
//	        } catch (Exception e) {
//	            return ResponseEntity.notFound().build(); 
//	        }
//	}
	
	
	@PutMapping("/updateStudent/{prn}")
	public ResponseEntity<StudentModel> updateStudentByPrn(@PathVariable String prn, @RequestBody StudentModel updatedStudent) {
	    Optional<StudentModel> existingStudentOptional = studentservice.getStudentByPrn(prn);
	    if (existingStudentOptional.isPresent()) {
	        StudentModel existingStudent = existingStudentOptional.get();
	        existingStudent.setStudentName(updatedStudent.getStudentName());
	        existingStudent.setStudentPrn(updatedStudent.getStudentPrn());
	        // Update other properties as needed
	        
	        StudentModel updated = studentservice.saveStudent(existingStudent);
	        return ResponseEntity.ok(updated);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/deleteStudentByPrn/{prn}")
	 public ResponseEntity<String> deleteStudent(@PathVariable String prn) {
		studentservice.deleteStudentByPrn(prn);
  return ResponseEntity.ok("Student with PRN " + prn + " deleted successfully.");
  
  
}
	
	
	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
	    studentservice.deleteAllStudents();
	    return ResponseEntity.ok("All students deleted successfully.");
	}

	
	
	
>>>>>>> 6a397e9 (Created create exam REST API)
	
}