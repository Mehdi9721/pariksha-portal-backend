package ServicesForRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.StudentModel;
import jpaRepositories.StudentRepository;
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
return Studentrepo.save(student);
}
public void deleteStudentByPrn(Long prn) {
    Studentrepo.deleteById(prn);
}
public void deleteAllStudents(Long prn) {
    Studentrepo.deleteById(prn);
}

}
