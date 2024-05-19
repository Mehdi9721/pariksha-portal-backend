package com.example.demo.ServicesForRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.ResultModel;
import com.example.demo.jpaRepositories.ResultModelRepository;

import java.util.List;

@Service
public class ResultModelService {

    @Autowired
    private ResultModelRepository resultModelRepository;

    public ResultModel saveStudent(ResultModel result) {
        return resultModelRepository.save(result);
    }

    public List<ResultModel> getAllStudents(String adminId) {
        return resultModelRepository.findAllResults(adminId);
    }

    public ResultModel getResultByPRN(String prn) {
        return resultModelRepository.findByStudentPrn(prn);
    }
    public ResultModel getResultByPRN(String prn,String adminId,String examId) {
        return resultModelRepository.findByStudentPrnAndAdminId(prn,adminId,examId);
    }

    public void deleteAllStudents(String adminId) {
        resultModelRepository.deleteAllResult(adminId);
    }

    public void deleteStudentByPRN(String prn,String examId) {
    
       
            resultModelRepository.deleteResultByPRNandExamId(prn,examId);
        
    }
    public ResultModel getresultByprnandExamid(String examId,String studentPrn) {
    ResultModel rm=	resultModelRepository.getStudentResultByExamIdandPrn(examId, studentPrn);
    return rm;
    }
}
