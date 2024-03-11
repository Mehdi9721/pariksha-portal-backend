package com.example.demo.RestComponents;

import com.example.demo.Models.QuestionPaperDataModel;
import com.example.demo.ServicesForRest.QuestionPaperService;
import com.example.demo.jpaRepositories.QuestionPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionPaperRest {

    @Autowired
    private QuestionPaperService questionPaperService;

    // Get all questions
    @GetMapping("/getAllQuestions/{adminEmail}")
    public List<QuestionPaperDataModel> getAllQuestions(@PathVariable String adminEmail) {
        return questionPaperService.getAllQuestions(adminEmail);
    }

    // Add a new question
    @PostMapping("/addQuestion")
    public QuestionPaperDataModel addQuestion(@RequestBody QuestionPaperDataModel question) {
        return questionPaperService.addQuestion(question);
    }

    // Delete all questions
    @DeleteMapping("/deleteAllQuestions/{adminEmail}")
    public String deleteAllQuestions(@PathVariable String adminEmail) {
    	questionPaperService.deleteAllQuestions(adminEmail);
        return "All questions deleted successfully.";
    }
    
    @GetMapping("/getAllQuestionsByExamId/{examId}")
    public List<QuestionPaperDataModel> getAllQuestionsByExamId(@PathVariable String examId) {
        return questionPaperService.findByExamId(examId);
    }
    

    @PostMapping("/uploadQuestionPaper")
    public String uploadFileForQuestionPaper(@RequestParam("file") MultipartFile file, @RequestParam("examId") String examId,@RequestParam("adminEmail") String adminEmail) {
    	questionPaperService.processAndSaveQuestionPaper(file,examId,adminEmail);
	 return "File uploaded successfully";
    }
    
    @DeleteMapping("/deleteQuestionById/{id}")
    public String deleteQuestionById(@PathVariable Long id) {
        questionPaperService.deleteQuestionById(id);
        return "Questions with Exam ID " + id + " deleted successfully.";
    }
    
    @DeleteMapping("/deleteQuestionByExamId/{examId}")
    public String deleteQuestionByExamId(@PathVariable String examId) {
        questionPaperService.deleteQuestionByExamId(examId);
        return "Questions with Exam ID " + examId+ " deleted successfully.";
    }

}