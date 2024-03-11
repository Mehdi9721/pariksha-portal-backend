package com.example.demo.ServicesForRest;
import org.apache.poi.ss.usermodel.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.Models.StudentModel;

public class ExcelFileProcessor {
	//for processing students data
    public static List<StudentModel> process(InputStream inputStream ,String adminId) {
        List<StudentModel> students = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell studentNameCell = row.getCell(2);
                Cell studentPrnCell = row.getCell(1);

                String studentName = getStringCellValue(studentNameCell);
                String studentPrn = getStringCellValue(studentPrnCell);

                StudentModel student = new StudentModel();
                student.setStudentName(studentName);
                student.setStudentPrn(studentPrn);
                student.setAdminId(adminId);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}
