package com.example.demo.RestComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.ResultModel;
import com.example.demo.ServicesForRest.ResultModelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultDataRest {

    @Autowired
    private ResultModelService resultModelService;

    @GetMapping("/getAllStudentResultData")
    public ResponseEntity<List<ResultModel>> getAllStudentResult() {
        List<ResultModel> results = resultModelService.getAllStudents();
        return ResponseEntity.ok(results);
    }

    @PostMapping("/postStudentResultData")
    public ResponseEntity<ResultModel> saveStudent(@RequestBody ResultModel result) {
        System.out.println("saveStudent url");
        ResultModel savedResult = resultModelService.saveStudent(result);
        return ResponseEntity.ok(savedResult);
    }

    @DeleteMapping("/deleteAllStudentResultData")
    public ResponseEntity<Void> deleteAllStudentResultData() {
        resultModelService.deleteAllStudents();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getStudentResultDataByStudentPrn/{prn}")
    public ResponseEntity<ResultModel> getStudentResultByPRN(@PathVariable String prn) {
    	System.out.println("ok");
        ResultModel result = resultModelService.getResultByPRN(prn);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteStudentResultDataByStudentPrn/{prn}")
    public ResponseEntity<Void> deleteStudentResultByPRN(@PathVariable String prn) {
        ResultModel result = resultModelService.getResultByPRN(prn);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        resultModelService.deleteStudentByPRN(prn);
        return ResponseEntity.noContent().build();
    }
}
