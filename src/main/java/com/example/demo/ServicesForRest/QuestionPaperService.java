package com.example.demo.ServicesForRest;

import com.example.demo.Models.QuestionPaperDataModel;
import com.example.demo.jpaRepositories.QuestionPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionPaperService {

    @Autowired
    private QuestionPaperRepository questionPaperDataRepository;

    public List<QuestionPaperDataModel> getAllQuestions() {
        return questionPaperDataRepository.findAll();
    }

    public QuestionPaperDataModel addQuestion(QuestionPaperDataModel question) {
        return questionPaperDataRepository.save(question);
    }

    public void deleteAllQuestions() {
        questionPaperDataRepository.deleteAll();
    }
    
    public List<QuestionPaperDataModel> getAllQuestionsByExamId(String examId) {
        return questionPaperDataRepository.findByExamId(examId);
    }
    
}