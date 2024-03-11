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
	    private String studentName;
	    private String studentPrn;
	    private String adminId;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
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
