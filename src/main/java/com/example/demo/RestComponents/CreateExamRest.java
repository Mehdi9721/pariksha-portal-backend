package com.example.demo.RestComponents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.CreateExamModel;
import com.example.demo.Models.StudentModel;
import com.example.demo.ServicesForRest.CreateExamService;

@RestController
@RequestMapping("/api")
public class CreateExamRest {

	@Autowired
	private CreateExamService createExamService ;
	
	
	@PostMapping("/createExam")
	public ResponseEntity<CreateExamModel> CreateExam(@RequestBody CreateExamModel Exam ){
		
		CreateExamModel Exam_created = createExamService.CreateExam(Exam);
		return ResponseEntity.ok(Exam_created);
		
	}
	
	@GetMapping("/getAllExams/{adminEmail}")
	public  ResponseEntity<List<CreateExamModel>> getAllExam(@PathVariable String adminEmail){
		  List<CreateExamModel> Exams = createExamService.getAllExam(adminEmail);
	        return ResponseEntity.ok(Exams);
	}
	
	
	@DeleteMapping("/deleteExam/{examId}")
    public ResponseEntity<CreateExamModel> deleteExam(@PathVariable String examId) {
        System.out.println("Deleting Exam with ID: " + examId);
        
        // Call the service method to delete the exam
        createExamService.deleteExamById(examId);
        
        return ResponseEntity.noContent().build();
    }
	
	
	 @DeleteMapping("/deleteAllExams/{adminEmail}")
	    public ResponseEntity<CreateExamModel> deleteAllExams(@PathVariable String adminEmail) {
	  
	        // Call the service method to delete all exams
	        createExamService.deleteAllExams(adminEmail);

	        return ResponseEntity.noContent().build();
	    }
	
	@GetMapping("/getExamByExamId/{examId}")
	public ResponseEntity<CreateExamModel> getExamByExamId(@PathVariable String examId) {
       CreateExamModel Exams=createExamService.examById(examId);
        return ResponseEntity.ok(Exams);
    }	
	
	
	
}
