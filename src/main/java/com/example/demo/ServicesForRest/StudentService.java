package com.example.demo.ServicesForRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.StudentModel;
import com.example.demo.jpaRepositories.StudentRepository;
@Service
public class StudentService {
@Autowired	
private StudentRepository Studentrepo; 

public List<StudentModel> getAllStudents(){
	return Studentrepo.findAll();
}
public StudentModel saveStudent(StudentModel student) {
return Studentrepo.save(student);
}
public StudentModel updateStudent(StudentModel student) {
 Studentrepo.delete(student);
return Studentrepo.save(student);
}
public void deleteStudentByPrn(String student) {
    Studentrepo.deleteByStudentPrn(student);
}
public void deleteAllStudents(StudentModel student) {
    Studentrepo.delete(student);
}

}