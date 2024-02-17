package com.example.demo.ServicesForRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.CreateExamModel;
import com.example.demo.jpaRepositories.CreateExamRepository;

@Service
public class CreateExamService {
	
@Autowired
private CreateExamRepository createExamRepo ;
	

public List<CreateExamModel> getAllExam(){
	return createExamRepo.findAll();
}

public CreateExamModel CreateExam(CreateExamModel Exam) {
return createExamRepo.save(Exam);
}

public void deleteExamById(String uniqueID) {
   
	createExamRepo.deleteById(uniqueID);
}


public void deleteAllExams() {
   
	createExamRepo.deleteAll();
}

}
