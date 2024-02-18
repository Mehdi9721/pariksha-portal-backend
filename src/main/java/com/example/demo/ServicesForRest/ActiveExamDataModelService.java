package com.example.demo.ServicesForRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.ActiveExamDataModel;
import com.example.demo.jpaRepositories.ActiveExamDataModelRepository;

import java.util.List;

@Service
public class ActiveExamDataModelService {

    @Autowired
    private ActiveExamDataModelRepository activeExamDataModelRepository;

    public ActiveExamDataModel saveActiveExamData(ActiveExamDataModel activeExamData) {
        return activeExamDataModelRepository.save(activeExamData);
    }

    public List<ActiveExamDataModel> getAllActiveExamData() {
        return activeExamDataModelRepository.findAll();
    }

    public void deleteAllActiveExamData() {
        activeExamDataModelRepository.deleteAll();
    }
}
