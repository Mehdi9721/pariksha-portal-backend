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
    Optional<StudentModel> existingStudent = getStudentByPrn(student.getStudentPrn());
    if (existingStudent.isPresent()) {
        // Handle the case where a student with the same PRN already exists
        // For example, you can throw an exception or return null
        // Here, I'll just return null for demonstration purposes
        return null;
    } else {
        return Studentrepo.save(student);
    }
}

public void updateStudent(StudentModel student) {
<<<<<<< HEAD
Studentrepo.updateStudent(student.getStudentPrn(),student.getStudentName());
=======
	 long studentPrn = Studentrepo.getStudentByPrn(student.getStudentPrn());
Studentrepo.updateStudent(student.getStudentPrn(),student.getStudentName(),studentPrn);
>>>>>>> 6a397e9 (Created create exam REST API)
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

public Optional<StudentModel> getStudentByPrn(String prn) {
    return Studentrepo.findByStudentPrn(prn);
}

public void deleteAllStudents() {
	Studentrepo.deleteAll();
}


}