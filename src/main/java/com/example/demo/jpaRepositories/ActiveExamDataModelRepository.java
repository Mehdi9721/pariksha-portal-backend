package com.example.demo.jpaRepositories;

import com.example.demo.Models.ActiveExamDataModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActiveExamDataModelRepository extends JpaRepository<ActiveExamDataModel, Long> {
   
	@Query("Select E from ActiveExamDataModel E where E.adminId = :adminId")
	List<ActiveExamDataModel> findAllExam(@Param("adminId") String adminId);
	
	void deleteByStudentPrn(String studentPrn);
}