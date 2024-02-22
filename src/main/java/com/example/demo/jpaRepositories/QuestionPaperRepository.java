package com.example.demo.jpaRepositories;

import com.example.demo.Models.QuestionPaperDataModel;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaperDataModel, Long> {
    
	 List<QuestionPaperDataModel> findByExamId(String examId);
	  
	  @Modifying
	    @Transactional
	    @Query("DELETE FROM QuestionPaperDataModel")
	    void deleteAllQuestions();
	  
	  
	  @Modifying
	    @Transactional
	    @Query("DELETE FROM QuestionPaperDataModel q WHERE q.examId = :examId")
	    void deleteQuestionByExamId(String examId);
	  
	  
}