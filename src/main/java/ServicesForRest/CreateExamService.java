package ServicesForRest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpaRepositories.CreateExamRepository;

import Models.CreateExamModel ;


@Service
public class CreateExamService {

	@Autowired
	private CreateExamRepository createExamRepository ;
	
	
	public List<CreateExamModel> getAllExamDetails(){
		return createExamRepository.findAll();
	}
	
	public CreateExamModel saveExamDetails(CreateExamModel Exam_details) {
		return createExamRepository.save(Exam_details);
	}
	
	public CreateExamModel UpdateExamDetails(CreateExamModel Exam_details) {
		return createExamRepository.save(Exam_details);
		
	}
	
	public void deleteExamByExamID(Long ExamID) {
		createExamRepository.deleteById(ExamID);
	}
	
	public void deleteAllExams() {
		createExamRepository.deleteAll();
	}
}
