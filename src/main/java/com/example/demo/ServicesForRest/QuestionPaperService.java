package com.example.demo.ServicesForRest;

import com.example.demo.Models.QuestionPaperDataModel;
import com.example.demo.Models.StudentModel;
import com.example.demo.jpaRepositories.QuestionPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class QuestionPaperService {

    @Autowired
    private QuestionPaperRepository questionPaperDataRepository;

    public List<QuestionPaperDataModel> getAllQuestions(String adminEmail) {
        return questionPaperDataRepository.findAllQuestions(adminEmail);
    }

    public QuestionPaperDataModel addQuestion(QuestionPaperDataModel question) {
        return questionPaperDataRepository.save(question);
    }

    public void deleteAllQuestions(String adminEmail) {
        questionPaperDataRepository.deleteAllQuestions(adminEmail);
    }

    
  
    public void processAndSaveQuestionPaper(MultipartFile file,String examId,String adminEmail) {
        try (InputStream inputStream = file.getInputStream()) {
           List<QuestionPaperDataModel> papers = ExcelFileProcessorOfPaper.process(inputStream);
           for (QuestionPaperDataModel questionPaper : papers) {
               questionPaper.setExamId(examId);
               questionPaper.setAdminEmail(adminEmail);
           }
        	questionPaperDataRepository.saveAll(papers);
        } catch (IOException e) {
            e.printStackTrace();
           
        }
    }

	public List<QuestionPaperDataModel> findByExamId(String examId) {
		
		  return questionPaperDataRepository.findByExamId(examId);
	}
	
	  public void deleteQuestionById(Long id) {
		  questionPaperDataRepository.deleteById(id);
		
	    }
	  public void deleteQuestionByExamId(String ExamId) {
		  questionPaperDataRepository.deleteQuestionByExamId(ExamId);
		
	    }
	
    
}