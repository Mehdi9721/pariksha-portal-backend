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

    public List<ResultModel> getAllStudents() {
        return resultModelRepository.findAll();
    }

    public ResultModel getResultByPRN(String prn) {
        return resultModelRepository.findByStudentPrn(prn);
    }

    public void deleteAllStudents() {
        resultModelRepository.deleteAll();
    }

    public void deleteStudentByPRN(String prn) {
        ResultModel result = getResultByPRN(prn);
        if (result != null) {
            resultModelRepository.delete(result);
        }
    }
    public ResultModel getresultByprnandExamid(String examId,String studentPrn) {
    ResultModel rm=	resultModelRepository.getStudentResultByExamIdandPrn(examId, studentPrn);
    return rm;
    }
}
