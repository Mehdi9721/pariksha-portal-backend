package com.example.demo.RestComponents;

import com.example.demo.Models.QuestionPaperDataModel;
import com.example.demo.jpaRepositories.QuestionPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionPaperRest {

    @Autowired
    private QuestionPaperRepository questionPaperDataRepository;

    // Get all questions
    @GetMapping("/getAllQuestions")
    public List<QuestionPaperDataModel> getAllQuestions() {
        return questionPaperDataRepository.findAll();
    }

    // Add a new question
    @PostMapping("/addQuestion")
    public QuestionPaperDataModel addQuestion(@RequestBody QuestionPaperDataModel question) {
        return questionPaperDataRepository.save(question);
    }

    // Delete all questions
    @DeleteMapping("/deleteAllQuestions")
    public String deleteAllQuestions() {
        questionPaperDataRepository.deleteAll();
        return "All questions deleted successfully.";
    }
    
    // Get all questions by Exam ID
    @GetMapping("/getAllQuestionsByExamId/{examId}")
    public List<QuestionPaperDataModel> getAllQuestionsByExamId(@PathVariable String examId) {
        return questionPaperDataRepository.findByExamId(examId);
    }
    
    
    
}