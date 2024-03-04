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
		
		System.out.println("Exam Created in table named : ExamRecord ");
		CreateExamModel Exam_created = createExamService.CreateExam(Exam);
		return ResponseEntity.ok(Exam_created);
		
	}
	
	@GetMapping("/getAllExams")
	public  ResponseEntity<List<CreateExamModel>> getAllExam(){
		  List<CreateExamModel> Exams = createExamService.getAllExam();
		  System.out.println("all exams");
	        return ResponseEntity.ok(Exams);
	}
	
	
	@DeleteMapping("/deleteExam/{examId}")
    public ResponseEntity<CreateExamModel> deleteExam(@PathVariable String examId) {
        System.out.println("Deleting Exam with ID: " + examId);
        
        // Call the service method to delete the exam
        createExamService.deleteExamById(examId);
        
        return ResponseEntity.noContent().build();
    }
	
	
	 @DeleteMapping("/deleteAllExams")
	    public ResponseEntity<CreateExamModel> deleteAllExams() {
	        System.out.println("Deleting all exams data from the table ExamRecords");

	        // Call the service method to delete all exams
	        createExamService.deleteAllExams();

	        return ResponseEntity.noContent().build();
	    }
	
	@GetMapping("/getExamByExamId/{examId}")
	public ResponseEntity<CreateExamModel> getExamByExamId(@PathVariable String examId) {
       CreateExamModel Exams=createExamService.examById(examId);
        return ResponseEntity.ok(Exams);
    }	
	
	
	
}
