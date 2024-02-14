package RestComponents;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Models.CreateExamModel;
import ServicesForRest.CreateExamService;

@RestController
@RequestMapping("/api")
public class CreateExamRest {

	@Autowired
	private CreateExamService createExamService ;
	
	@PostMapping("/saveExam")
	public ResponseEntity<CreateExamModel> saveExamDetails(@RequestBody CreateExamModel Exam_Details){
		CreateExamModel ExamSave = createExamService.saveExamDetails(Exam_Details);
		return ResponseEntity.ok(ExamSave);
	}
	
	@GetMapping("/getAllExam")
	public ResponseEntity<List<CreateExamModel>> getallExamDetails(){
		 List<CreateExamModel> ExamDetails = createExamService.getAllExamDetails();
	        return ResponseEntity.ok(ExamDetails);
		
	}
	
	@PutMapping("/updateExam")
	public ResponseEntity<CreateExamModel> updatExamDetails(@RequestBody CreateExamModel Exam_details){
		CreateExamModel ExamUpdate=createExamService.UpdateExamDetails(Exam_details);
		return ResponseEntity.ok(ExamUpdate);
	}
	
	public ResponseEntity<String> deleteExamDetails(@PathVariable Long Exam_id){
		createExamService.deleteExamByExamID(Exam_id);
		
		return ResponseEntity.ok("Exam Details with Exam_ID" + Exam_id + "deleted Successfully . ");
	}
	
	
}
