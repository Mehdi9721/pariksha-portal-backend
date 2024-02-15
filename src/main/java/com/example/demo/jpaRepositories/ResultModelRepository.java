package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.ResultModel;

@Repository
public interface ResultModelRepository extends JpaRepository<ResultModel, Long> {
	 ResultModel findByStudentPrn(String prn);  
}
