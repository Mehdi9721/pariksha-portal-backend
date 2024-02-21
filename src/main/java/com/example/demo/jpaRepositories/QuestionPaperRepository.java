package com.example.demo.jpaRepositories;

import com.example.demo.Models.QuestionPaperDataModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaperDataModel, Long> {
    
	 List<QuestionPaperDataModel> findByExamId(String examId);
}