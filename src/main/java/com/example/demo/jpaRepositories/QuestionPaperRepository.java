package com.example.demo.jpaRepositories;

import com.example.demo.Models.QuestionPaperDataModel;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaperDataModel, Long> {
    
	 List<QuestionPaperDataModel> findByExamId(String examId);
	  
	  @Modifying
	    @Transactional
	    @Query("DELETE FROM QuestionPaperDataModel E where E.adminEmail= :adminEmail ")
	    void deleteAllQuestions(@Param("adminEmail") String adminEmail);
	  
	  
	  @Modifying
	    @Transactional
	    @Query("DELETE FROM QuestionPaperDataModel q WHERE q.examId = :ExamId")
	    void deleteQuestionByExamId(@Param("ExamId") String ExamId);
	  
	  @Query("Select E from QuestionPaperDataModel E where E.adminEmail= :adminEmail")
	 List<QuestionPaperDataModel> findAllQuestions(@Param("adminEmail") String adminEmail);
	  
	  
	  
}