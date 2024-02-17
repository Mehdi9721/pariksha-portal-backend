package com.example.demo.jpaRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.StudentModel;

import jakarta.transaction.Transactional;
@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long>{

	@Transactional
    @Modifying
	@Query("delete FROM StudentModel s WHERE s.studentPrn = :studentPrn")
    void deleteByStudentPrn(@Param("studentPrn") String studentPrn);
	
	  @Transactional
      @Modifying
<<<<<<< HEAD
	  @Query("UPDATE StudentModel s SET s.studentName = :name, s.studentPrn = :prn WHERE s.studentPrn = :studentPrn")
	  void updateStudent(@Param("prn") String prn, @Param("name") String name);
	  
	  @Query("SELECT s.id FROM StudentModel s WHERE s.studentPrn = :studentPrn")
	    long getStudentByPrn(@Param("studentPrn") String studentPrn);  
	  StudentModel findByStudentPrn(String prn);
	
}
	
=======
	  @Query("UPDATE StudentModel s SET s.studentName = :name, s.studentPrn = :prn WHERE s.id = :id")
	  void updateStudent(@Param("prn") String studentPrn, @Param("name") String name, @Param("id") long id);
	  
	  @Query("SELECT s.id FROM StudentModel s WHERE s.studentPrn = :studentPrn")
	    long getStudentByPrn(@Param("studentPrn") String studentPrn);  
	  
	  @Query("SELECT s FROM StudentModel s WHERE s.studentPrn = :studentPrn")
	  Optional<StudentModel> findByStudentPrn(String studentPrn);
	  
	  
	 
}
>>>>>>> 6a397e9 (Created create exam REST API)
