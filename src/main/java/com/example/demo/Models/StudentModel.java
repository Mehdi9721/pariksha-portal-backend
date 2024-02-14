package com.example.demo.Models;

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
	    private String student_name;
	    private String student_prn;
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getStudent_prn() {
			return student_prn;
		}
		public void setStudent_prn(String student_prn) {
			this.student_prn = student_prn;
		}
	    }
