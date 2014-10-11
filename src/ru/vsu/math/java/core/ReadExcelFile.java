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

    public static List<Table> readExcelFile(String fileName){

        List<Table> tableList = new ArrayList<Table>();
        double id = 0;
        String name = "";
        double CG1 = 0;
        double CG2 = 0;
        double CG3 = 0;
        double CG4 = 0;
        double CG5 = 0;
        double CG6 = 0;
        double CG7 = 0;
        double CG8 = 0;
        double CG9 = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = null;

            if (fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fileInputStream);
            }
            else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fileInputStream);
            }

            Sheet sheet = workbook.getSheetAt(0);
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
                                   CG1 = cell.getNumericCellValue();
                               break;
                               case 3:
                                   CG2 = cell.getNumericCellValue();
                                   break;
                               case 4:
                                   CG3 = cell.getNumericCellValue();
                                   break;
                               case 5:
                                   CG4 = cell.getNumericCellValue();
                                   break;
                               case 6:
                                   CG5 = cell.getNumericCellValue();
                                   break;
                               case 7:
                                   CG6 = cell.getNumericCellValue();
                                   break;
                               case 8:
                                   CG7 = cell.getNumericCellValue();
                                   break;
                               case 9:
                                   CG8 = cell.getNumericCellValue();
                                   break;
                               case 10:
                                   CG9 = cell.getNumericCellValue();
                                   break;
                           }
                           break;
                       case Cell.CELL_TYPE_STRING:
                           //System.out.print(cell.getStringCellValue() + "\t\t");
                           name = cell.getStringCellValue();
                           break;
                       case CELL_TYPE_BLANK:
                           cell.setCellValue("");
                           break;
                   }

               }
                //System.out.println("");
                Table table = new Table(id, CG1, CG2, CG3, CG4, CG5, CG6, CG7, CG8, CG9, name);
                tableList.add(table);
            }

            fileInputStream.close();
            System.out.println(fileName + " - чтение файла завершено.");


        }  catch (IOException e) {
            e.printStackTrace();
        }
        return tableList;
    }
}
