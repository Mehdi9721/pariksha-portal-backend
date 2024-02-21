package com.example.demo.ServicesForRest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.example.demo.Models.QuestionPaperDataModel;
import com.example.demo.Models.StudentModel;
public class ExcelFileProcessorOfPaper {
	  public static List<QuestionPaperDataModel> process(InputStream inputStream) {
	        List<QuestionPaperDataModel> papers = new ArrayList<>();
	        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
	            Sheet sheet = workbook.getSheetAt(0); 	            
	            Iterator<Row> rowIterator = sheet.iterator();
	            rowIterator.next();
;	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Cell questionCell = row.getCell(0);
	                Cell optionACell = row.getCell(1);
	                Cell optionBCell = row.getCell(2);
	                Cell optionCCell = row.getCell(3);
	                Cell optionDCell = row.getCell(4);
	                Cell answerCell = row.getCell(5);

	                String question = getStringCellValue(questionCell);
	                String optA = getStringCellValue(optionACell);
	                String optB = getStringCellValue(optionBCell);
	                String optC = getStringCellValue(optionCCell);
	                String optD = getStringCellValue(optionDCell);
	                String ans = getStringCellValue(answerCell);
	                QuestionPaperDataModel paper = new QuestionPaperDataModel();
	                paper.setQuestion(question);
	                paper.setOptionA(optA);
	                paper.setOptionB(optB);
	                paper.setOptionC(optC);
	                paper.setOptionD(optD);
	                paper.setAnswer(ans);
	                papers.add(paper);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return papers;
	    }

	    private static String getStringCellValue(Cell cell) {
	        if (cell == null) {
	            return null;
	        }
	        cell.setCellType(CellType.STRING);
	        return cell.getStringCellValue();
	    }
}
