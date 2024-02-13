package jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel,Long>{

}
	