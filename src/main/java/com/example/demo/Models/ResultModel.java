package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "ResultRecords")
public class ResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentPrn;
    private String studentName;
    private String studentResultDownloadLink;  
    private String examName;
    private String examDate;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public ResultModel() {
    }

    // Parameterized constructor
    public ResultModel(String studentPrn, String studentName, String studentResultDownloadLink, String examName, String examDate) {
        this.studentPrn = studentPrn;
        this.studentName = studentName;
        this.studentResultDownloadLink = studentResultDownloadLink;
        this.examName = examName;
        this.examDate = examDate;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentPrn() {
        return studentPrn;
    }

    public void setStudentPrn(String studentPrn) {
        this.studentPrn = studentPrn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentResultDownloadLink() {
        return studentResultDownloadLink;
    }

    public void setStudentResultDownloadLink(String studentResultDownloadLink) {
        this.studentResultDownloadLink = studentResultDownloadLink;
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
}
