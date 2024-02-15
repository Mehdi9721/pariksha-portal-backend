package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Examsrecord")
public class CreateExamModel {
	
	public CreateExamModel() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String  Exam_id ;
	private String Exam_Name;
	private String Exam_Date;
	private int Exam_Duration ;
	//@ManyToOne
   // @JoinColumn(name = "QuestionPaperID")
	//private QuestionPaperDataModel QuestionPaperID ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExam_id() {
		return Exam_id;
	}
	public void setExam_id(String exam_id) {
		Exam_id = exam_id;
	}
	public String getExam_Name() {
		return Exam_Name;
	}
	public void setExam_Name(String exam_Name) {
		Exam_Name = exam_Name;
	}
	public String getExam_Date() {
		return Exam_Date;
	}
	public void setExam_Date(String exam_Date) {
		Exam_Date = exam_Date;
	}
	public int getExam_Duration() {
		return Exam_Duration;
	}
	public void setExam_Duration(int exam_Duration) {
		Exam_Duration = exam_Duration;
	}
//	public QuestionPaperDataModel getQuestionPaperID() {
//		return QuestionPaperID;
//	}
//	public void setQuestionPaperID(QuestionPaperDataModel questionPaperID) {
//		QuestionPaperID = questionPaperID;
//	}

}
