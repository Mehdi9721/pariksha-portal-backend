package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.ResultModel;

@Repository
public interface ResultModelRepository extends JpaRepository<ResultModel, Long> {
	
	 ResultModel findByStudentPrn(String prn);
	 
	  @Query("SELECT r FROM ResultModel r WHERE r.examId = :examId AND r.studentPrn = :studentPrn")
	 ResultModel  getStudentResultByExamIdandPrn(@Param("examId") String examId, @Param("studentPrn") String studentPrn);
}