package com.example.demo.RestComponents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		StudentModel studSave=studentservice.saveStudent(Student);
		return ResponseEntity.ok(studSave);
	}
	@GetMapping("/getAllStudent")
	public  ResponseEntity<List<StudentModel>> getAllStudent(){
		  List<StudentModel> students = studentservice.getAllStudents();
	        return ResponseEntity.ok(students);
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel Student){
		StudentModel studUpdate=studentservice.saveStudent(Student);
		return ResponseEntity.ok(studUpdate);
	}
	@DeleteMapping("/delete")
	 public ResponseEntity<String> deleteStudent(@RequestBody StudentModel Student) {
		studentservice.deleteStudentByPrn(Student.getStudent_prn());
  return ResponseEntity.ok("Student with PRN " + Student + " deleted successfully.");
}
}