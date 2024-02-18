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
	private String  examId ;
	private String examName;
	private String examDate;
	private int examDuration ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public int getExamDuration() {
		return examDuration;
	}
	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}
	
	
	//@ManyToOne
   // @JoinColumn(name = "QuestionPaperID")
	//private QuestionPaperDataModel QuestionPaperID ;
	
//	public QuestionPaperDataModel getQuestionPaperID() {
//		return QuestionPaperID;
//	}
//	public void setQuestionPaperID(QuestionPaperDataModel questionPaperID) {
//		QuestionPaperID = questionPaperID;
//	}

}
