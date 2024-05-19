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

    @GetMapping("/getAllStudentResultData/{adminId}")
    public ResponseEntity<List<ResultModel>> getAllStudentResult(@PathVariable String adminId) {
        List<ResultModel> results = resultModelService.getAllStudents(adminId);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/postStudentResultData")
    public ResponseEntity<ResultModel> saveStudent(@RequestBody ResultModel result) {
        ResultModel savedResult = resultModelService.saveStudent(result);
        return ResponseEntity.ok(savedResult);
    }

    @DeleteMapping("/deleteAllStudentResultData/{adminId}")
    public ResponseEntity<Void> deleteAllStudentResultData(@PathVariable String adminId) {
        resultModelService.deleteAllStudents(adminId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getStudentResultDataByStudentPrn/{prn}/{adminId}/{examId}")
    public ResponseEntity<ResultModel> getStudentResultByPRN(@PathVariable String prn,@PathVariable String adminId,@PathVariable String examId) {
        ResultModel result = resultModelService.getResultByPRN(prn,adminId,examId);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteStudentResultDataByStudentPrn/{prn}/{examId}")
    public ResponseEntity<Void> deleteStudentResultByPRN(@PathVariable String prn,@PathVariable String examId) {
//        ResultModel result = resultModelService.getResultByPRN(prn,examId);
//        if (result == null) {
//            return ResponseEntity.notFound().build();
//        }
        resultModelService.deleteStudentByPRN(prn,examId);
        return ResponseEntity.noContent().build();
    }
}
