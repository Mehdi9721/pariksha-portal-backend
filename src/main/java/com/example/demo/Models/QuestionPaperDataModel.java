package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="QuestionPaperRecords")
public class QuestionPaperDataModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id ;
	
	private String QuestionPaperId ;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getQuestionPaperId() {
		return QuestionPaperId;
	}
	public void setQuestionPaperId(String questionPaperId) {
		QuestionPaperId = questionPaperId;
	}
	private String QuestionPaperName ;
	
	public String getQuestionPaperName() {
		return QuestionPaperName;
	}
	public void setQuestionPaperName(String questionPaperName) {
		QuestionPaperName = questionPaperName;
	}
	
}
