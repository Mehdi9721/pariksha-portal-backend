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

    public List<ResultModel> getAllResultModels() {
        return resultModelRepository.findAll();
    }
    
    public ResultModel postAllResultModels(ResultModel result) {
        return resultModelRepository.save(result);
    }

    public ResultModel saveStudent(ResultModel student) {
        return resultModelRepository.save(student);
    }

    public ResultModel saveResult(ResultModel result) {
        return resultModelRepository.save(result); 
    }

    public List<ResultModel> getAllStudents() {
        return resultModelRepository.findAll();
    }

    public ResultModel getResultByPRN(String prn) {
        return resultModelRepository.findByStudentPrn(prn);
    }
}
