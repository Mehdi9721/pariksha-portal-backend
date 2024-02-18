package com.example.demo.RestComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.ActiveExamDataModel;
import com.example.demo.ServicesForRest.ActiveExamDataModelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActiveExamRecordRest {

    @Autowired
    private ActiveExamDataModelService activeExamDataModelService;

    @GetMapping("/getAllActiveExamData")
    public ResponseEntity<List<ActiveExamDataModel>> getAllActiveExamData() {
        List<ActiveExamDataModel> activeExamData = activeExamDataModelService.getAllActiveExamData();
        return ResponseEntity.ok(activeExamData);
    }

    @PostMapping("/postActiveExamData")
    public ResponseEntity<ActiveExamDataModel> postActiveExamData(@RequestBody ActiveExamDataModel activeExamData) {
        ActiveExamDataModel savedActiveExamData = activeExamDataModelService.saveActiveExamData(activeExamData);
        return ResponseEntity.ok(savedActiveExamData);
    }

    @DeleteMapping("/deleteAllActiveExamData")
    public ResponseEntity<Void> deleteAllActiveExamData() {
        activeExamDataModelService.deleteAllActiveExamData();
        return ResponseEntity.noContent().build();
    }
}
