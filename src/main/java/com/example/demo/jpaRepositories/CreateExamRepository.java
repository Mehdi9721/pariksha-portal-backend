package com.example.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.CreateExamModel;

import jakarta.transaction.Transactional;


@Repository
@EnableJpaRepositories
public interface CreateExamRepository extends JpaRepository<CreateExamModel, Long> {
	
	
	@Transactional
    @Modifying
	@Query("delete FROM CreateExamModel E WHERE E.uniqueID = :ExamID")
    void deleteById(@Param("ExamID") String ExamID);
	//void deleteById(String examId);

	

}
