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

public List<StudentModel> getAllStudents(){
	return Studentrepo.findAll();
}
public StudentModel saveStudent(StudentModel student) {
return Studentrepo.save(student);
}
public void updateStudent(StudentModel student) {
Studentrepo.updateStudent(student.getStudentPrn(),student.getStudentName());
}
public void deleteStudentByPrn(String student) {
    Studentrepo.deleteByStudentPrn(student);
}
public void deleteAllStudents() {
    Studentrepo.deleteAll();;
}
public StudentModel findStudentbyPrn(String prn) {
	return Studentrepo.findByStudentPrn(prn);
}
public void processAndSaveFile(MultipartFile file) {
    try (InputStream inputStream = file.getInputStream()) {
        List<StudentModel> students = ExcelFileProcessor.process(inputStream);
        Studentrepo.saveAll(students);
    } catch (IOException e) {
        e.printStackTrace();
        // Handle exception
    }
}
}
