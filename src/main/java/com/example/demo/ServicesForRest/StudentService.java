package com.example.demo.ServicesForRest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Models.StudentModel;
import com.example.demo.jpaRepositories.StudentRepository;
@Service
public class StudentService {
@Autowired	
private StudentRepository Studentrepo; 

public List<StudentModel> getAllStudents(String adminId){
	return Studentrepo.findAllStu(adminId);
}
public StudentModel saveStudent(StudentModel student) {
return Studentrepo.save(student);
}
public void updateStudent(StudentModel student) {
Studentrepo.updateStudent(student.getStudentPrn(),student.getStudentName());
}
public void deleteStudentByPRN(String prn) {
   
	Studentrepo.deleteByStudentPrn(prn);
}
public void deleteAllStudents(String adminId) {
    Studentrepo.deleteAllStudent(adminId);;
}
public StudentModel findStudentbyPrn(String prn,String adminId) {
	return Studentrepo.findByStudentPrn(prn,adminId);
}
public void processAndSaveFile(MultipartFile file,String adminId) {
    try (InputStream inputStream = file.getInputStream()) {
        List<StudentModel> students = ExcelFileProcessor.process(inputStream,adminId);
        Studentrepo.saveAll(students);
    } catch (IOException e) {
        e.printStackTrace();
        // Handle exception
    }
}
}
