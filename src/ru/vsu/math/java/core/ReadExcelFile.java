package ru.vsu.math.java.core;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 * Created by Dima on 05.10.14.
 */
public class ReadExcelFile {

    public static List<RowExcel> readExcelFile(String fileName){

        List<RowExcel> table = new ArrayList<RowExcel>();
        double id = 0;
        double cg1 = 0;
        double cg2 = 0;
        double cg3 = 0;
        double cg4 = 0;
        double cg5 = 0;
        double cg6 = 0;
        double cg7 = 0;
        double cg8 = 0;
        double cg9 = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = null;

            if (fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fileInputStream);
            }
            else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fileInputStream);
            }

            int numberOfSheets = workbook.getNumberOfSheets();
            for(int numberOfSheet=0; numberOfSheet < numberOfSheets; numberOfSheet++){

                Sheet sheet = workbook.getSheetAt(numberOfSheet);

                Iterator<Row> rowIterator = sheet.iterator();
                while(rowIterator.hasNext()){

                 Row row = rowIterator.next();
                 Iterator<Cell> cellIterator = row.iterator();
                 int i=0;
                 while (cellIterator.hasNext()){

                   Cell cell = cellIterator.next();
                   i++;
                   switch(cell.getCellType()) {
                       case Cell.CELL_TYPE_NUMERIC:
                           //System.out.print(cell.getNumericCellValue() + "\t\t");
                           switch(i){
                               case 1:
                                   id = cell.getNumericCellValue();
                               break;
                               case 2:
                                   cg1 = cell.getNumericCellValue();
                               break;
                               case 3:
                                   cg2 = cell.getNumericCellValue();
                                   break;
                               case 4:
                                   cg3 = cell.getNumericCellValue();
                                   break;
                               case 5:
                                   cg4 = cell.getNumericCellValue();
                                   break;
                               case 6:
                                   cg5 = cell.getNumericCellValue();
                                   break;
                               case 7:
                                   cg6 = cell.getNumericCellValue();
                                   break;
                               case 8:
                                   cg7 = cell.getNumericCellValue();
                                   break;
                               case 9:
                                   cg8 = cell.getNumericCellValue();
                                   break;
                               case 10:
                                   cg9 = cell.getNumericCellValue();
                                   break;
                           }
                           break;
                       case CELL_TYPE_BLANK:
                           cell.setCellValue("");
                           break;
                   }

               }
                //System.out.println("");
                RowExcel rowExcel = new RowExcel(id, cg1, cg2, cg3, cg4, cg5, cg6, cg7, cg8, cg9);
                table.add(rowExcel);
               }

            }
            fileInputStream.close();
            System.out.println(fileName + " - чтение файла завершено.");

        }  catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
}
