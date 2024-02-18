package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activeExamRecords")
public class ActiveExamDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examDate;
    private String examName;
    private String studentName;
    private String studentPrn;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public ActiveExamDataModel() {
    }

    // Parameterized constructor
    public ActiveExamDataModel(String examDate, String examName, String studentName, String studentPrn) {
        this.examDate = examDate;
        this.examName = examName;
        this.studentName = studentName;
        this.studentPrn = studentPrn;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
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

