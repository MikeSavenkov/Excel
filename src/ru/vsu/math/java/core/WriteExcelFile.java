package ru.vsu.math.java.core;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Created by Dima on 05.10.14.
 */
public class WriteExcelFile {

    public void writeExcelFile(String fileName, List<RowExcel> table) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        try {

            Workbook workbook;

            if (fileName.endsWith("xlsx")) {
                workbook = new XSSFWorkbook();
            } else if (fileName.endsWith("xls")) {
                workbook = new HSSFWorkbook();
            } else {
                throw new Exception("invalid file name, should be xls or xlsx");
            }

            Sheet sheet = workbook.createSheet("Экспериментальные данные");

            Iterator<RowExcel> iterator = table.iterator();

            int rowIndex = 0;
            while (iterator.hasNext()) {

                RowExcel rowExcel = iterator.next();
                Row row = sheet.createRow(rowIndex++);

                Cell cell0 = row.createCell(0);
                cell0.setCellValue(rowExcel.id);

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(rowExcel.cg1);

                Cell cell2 = row.createCell(2);
                cell2.setCellValue(rowExcel.cg2);

                Cell cell3 = row.createCell(3);
                cell3.setCellValue(rowExcel.cg3);

                Cell cell4 = row.createCell(4);
                cell4.setCellValue(rowExcel.cg4);

                Cell cell5 = row.createCell(5);
                cell5.setCellValue(rowExcel.cg5);

                Cell cell6 = row.createCell(6);
                cell6.setCellValue(rowExcel.cg6);

                Cell cell7 = row.createCell(7);
                cell7.setCellValue(rowExcel.cg7);

                Cell cell8 = row.createCell(8);
                cell8.setCellValue(rowExcel.cg8);

                Cell cell9 = row.createCell(9);
                cell9.setCellValue(rowExcel.cg9);

            }


            workbook.write(fileOutputStream);
            System.out.println(fileName + " - запись файла завершена.");

        } finally {

            fileOutputStream.close();

        }

    }
}

