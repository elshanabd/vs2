/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author elshan_abdullayev
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class WriteXLSX {
	public static void main(String[] args) throws IOException {
            XSSFWorkbook workbook;
            try (FileInputStream fis = new FileInputStream(new File("D:/desk/test.xlsx"))) {
                workbook = new XSSFWorkbook (fis);
                XSSFSheet sheet = workbook.getSheetAt(0);
                XSSFRow row1 = sheet.createRow(0);
                XSSFCell r1c1 = row1.createCell(0);
                r1c1.setCellValue("Emd Id");
                XSSFCell r1c2 = row1.createCell(1);
                r1c2.setCellValue("NAME");
                XSSFCell r1c3 = row1.createCell(2);
                r1c3.setCellValue("AGE");
                XSSFRow row2 = sheet.createRow(1);
                XSSFCell r2c1 = row2.createCell(0);
                r2c1.setCellValue("1");
                XSSFCell r2c2 = row2.createCell(1);
                r2c2.setCellValue("Ram");
                XSSFCell r2c3 = row2.createCell(2);
                r2c3.setCellValue("20");
                XSSFRow row3 = sheet.createRow(2);
                XSSFCell r3c1 = row3.createCell(0);
                r3c1.setCellValue("2");
                XSSFCell r3c2 = row3.createCell(1);
                r3c2.setCellValue("Shyam");
                XSSFCell r3c3 = row3.createCell(2);
                r3c3.setCellValue("25");
            }
            try (FileOutputStream fos = new FileOutputStream(new File("D:\\desk\\test2.xlsx"))) {
                workbook.write(fos);
            }
		System.out.println("Done");
	}
} 