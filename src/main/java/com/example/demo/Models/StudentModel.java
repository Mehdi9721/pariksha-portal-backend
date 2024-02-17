package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//students record Model
@Entity
@Table(name = "studentsrecord")
public class StudentModel {
	  public StudentModel() {
	    }
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String studentName;
	    private String studentPrn;
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getStudentPrn() {
			return studentPrn;
		}
		public void setStudentPrn(String studentPrn) {
			this.studentPrn = studentPrn;
		}
		

	    }
