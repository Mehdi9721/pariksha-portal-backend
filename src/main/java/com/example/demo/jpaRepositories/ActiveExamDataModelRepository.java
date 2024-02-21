package com.example.demo.jpaRepositories;

import com.example.demo.Models.ActiveExamDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveExamDataModelRepository extends JpaRepository<ActiveExamDataModel, Long> {
   
	
	void deleteByStudentPrn(String studentPrn);
}