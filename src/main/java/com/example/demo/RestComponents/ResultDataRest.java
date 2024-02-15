package com.example.demo.RestComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.ResultModel;
import com.example.demo.Models.StudentModel;
import com.example.demo.ServicesForRest.ResultModelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultDataRest {

    @Autowired
    private ResultModelService resultModelService;

    @PostMapping("/postresultdata")   
    public ResponseEntity<ResultModel> saveStudent(@RequestBody ResultModel result){
        System.out.println("saveStudent url");
        ResultModel savedResult = resultModelService.saveStudent(result);
        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/getAllStudentResult")
    public ResponseEntity<List<ResultModel>> getAllStudentResult(){
        List<ResultModel> results = resultModelService.getAllStudents();
        return ResponseEntity.ok(results);
    }
    
    @GetMapping("/getResultByPRN/{prn}")
    public ResponseEntity<ResultModel> getResultByPRN(@PathVariable String prn){
        ResultModel result = resultModelService.getResultByPRN(prn);
        if(result == null) {
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(result);
    }
}


