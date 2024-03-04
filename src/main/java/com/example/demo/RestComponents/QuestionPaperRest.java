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
    @GetMapping("/getAllQuestions")
    public List<QuestionPaperDataModel> getAllQuestions() {
        return questionPaperService.getAllQuestions();
    }

    // Add a new question
    @PostMapping("/addQuestion")
    public QuestionPaperDataModel addQuestion(@RequestBody QuestionPaperDataModel question) {
        return questionPaperService.addQuestion(question);
    }

    // Delete all questions
    @DeleteMapping("/deleteAllQuestions")
    public String deleteAllQuestions() {
    	questionPaperService.deleteAllQuestions();
        return "All questions deleted successfully.";
    }
    
    @GetMapping("/getAllQuestionsByExamId/{examId}")
    public List<QuestionPaperDataModel> getAllQuestionsByExamId(@PathVariable String examId) {
        return questionPaperService.findByExamId(examId);
    }
    

    @PostMapping("/uploadQuestionPaper")
    public String uploadFileForQuestionPaper(@RequestParam("file") MultipartFile file, @RequestParam("examId") String examId) {
    	questionPaperService.processAndSaveQuestionPaper(file,examId);
	 return "File uploaded successfully";
    }
    
    @DeleteMapping("/deleteQuestionByExamId/{id}")
    public String deleteQuestionByExamId(@PathVariable Long id) {
        questionPaperService.deleteQuestionByExamId(id);
        return "Questions with Exam ID " + id + " deleted successfully.";
    }

}