package com.example.demo.jpaRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.ResultModel;

import jakarta.transaction.Transactional;

@Repository
public interface ResultModelRepository extends JpaRepository<ResultModel, Long> {
	
	 ResultModel findByStudentPrn(String prn);
	 
	  @Query("SELECT r FROM ResultModel r WHERE r.examId = :examId AND r.studentPrn = :studentPrn")
	 ResultModel  getStudentResultByExamIdandPrn(@Param("examId") String examId, @Param("studentPrn") String studentPrn);
	  
	  @Query("SELECT r FROM ResultModel r WHERE r.adminId = :adminId")
	  List<ResultModel> findAllResults(@Param("adminId") String adminId);
	  
	  @Transactional
	  @Modifying
	  @Query("delete  from ResultModel E where E.adminId= :adminId")
	  void deleteAllResult(@Param("adminId") String adminId);
	 
	  @Transactional
	  @Modifying
	  @Query("delete  from ResultModel E where E.studentPrn= :studentPrn and E.examId= :examId")
	  void deleteResultByPRNandExamId(@Param("studentPrn") String studentPrn, @Param("examId") String examId);
	  
	  @Query("SELECT r FROM ResultModel r WHERE r.adminId = :adminId and r.studentPrn= :studentPrn and r.examId= :examId")
	  ResultModel findByStudentPrnAndAdminId(@Param("studentPrn")String prn,@Param("adminId")String adminId,@Param("examId")String examId);
}