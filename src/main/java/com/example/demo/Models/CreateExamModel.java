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
	private String  uniqueID ;
	private String examName;
	private String examDate;
	private int examDuration ;
	//private String Question ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
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
//	public String getQuestion() {
//		return Question;
//	}
//	public void setQuestion(String question) {
//		Question = question;
//	}
	
	
//	public QuestionPaperDataModel getQuestionPaperID() {
//		return QuestionPaperID;
//	}
//	public void setQuestionPaperID(QuestionPaperDataModel questionPaperID) {
//		QuestionPaperID = questionPaperID;
//	}

}
