package ru.vsu.math.java.core;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;


/**
 * Created by Dima on 05.10.14.
 */
public class ReadExcelFile {

    private List<RowExcel> table = new ArrayList<RowExcel>();

    public List<RowExcel> readExcelFile(String fileName) throws Exception{

        FileInputStream fileInputStream = new FileInputStream(fileName);

        try {

            Workbook workbook = null;

            if (fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fileInputStream);
            }
            else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fileInputStream);
            }

            for(int numberOfSheet=0; numberOfSheet < workbook.getNumberOfSheets(); numberOfSheet++){

                Sheet sheet = workbook.getSheetAt(numberOfSheet);
                Iterator<Row> rowIterator = sheet.iterator();

                while(rowIterator.hasNext()){

                 Row row = rowIterator.next();
                 Iterator<Cell> cellIterator = row.iterator();
                 int i=0;
                 RowExcel rowExcel = new RowExcel(0,0,0,0,0,0,0,0,0,0);

                 while (cellIterator.hasNext()){

                   Cell cell = cellIterator.next();
                   i++;
                   switch(cell.getCellType()) {
                       case Cell.CELL_TYPE_NUMERIC:

                           switch(i){

                               case 1:
                                   rowExcel.id = cell.getNumericCellValue();
                               break;

                               case 2:
                                   rowExcel.cg1 = cell.getNumericCellValue();
                               break;

                               case 3:
                                   rowExcel.cg2 = cell.getNumericCellValue();
                                   break;

                               case 4:
                                   rowExcel.cg3 = cell.getNumericCellValue();
                                   break;

                               case 5:
                                   rowExcel.cg4 = cell.getNumericCellValue();
                                   break;

                               case 6:
                                   rowExcel.cg5 = cell.getNumericCellValue();
                                   break;

                               case 7:
                                   rowExcel.cg6 = cell.getNumericCellValue();
                                   break;

                               case 8:
                                   rowExcel.cg7 = cell.getNumericCellValue();
                                   break;

                               case 9:
                                   rowExcel.cg8 = cell.getNumericCellValue();
                                   break;

                               case 10:
                                   rowExcel.cg9 = cell.getNumericCellValue();
                                   break;
                           }
                           break;
                       case CELL_TYPE_BLANK:
                           cell.setCellValue("");
                           break;
                   }

                 }

                 table.add(rowExcel);
               }

               Collections.sort(table, new Comparator<RowExcel>() {
                    @Override
                    public int compare(RowExcel rowExcel1, RowExcel rowExcel2) {

                        double id1 = rowExcel1.id;
                        double id2 = rowExcel2.id;

                        if (id1 < id2) {
                            return -1;
                        } else if (id1 > id2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
               });

               //Усреднение результатов в столбце по id
               columnAverage();
            }

            System.out.println(fileName + " - чтение файла завершено.");

        }  catch (IOException e) {
            e.printStackTrace();
        }  finally {

            fileInputStream.close();
            return table;
        }

    }

    public void columnAverage(){

        List<RowExcel> temp = table;
        table = new ArrayList<RowExcel>();
        int i=0;
        double idMean=temp.get(i).id; // контроллер для проверки того, что мы пока просматриваем элементы с одинаковым id
        RowExcel averageRow; // строка с усредненными ячейками

        while (i<temp.size()) {
            int k=0; // счётчик для усреднения
            averageRow = new RowExcel(temp.get(i).id); // маркировка id
            while ((i<temp.size()) && (idMean == temp.get(i).id)) { // проход по записям с одинаковым id

                k++;

                averageRow.cg1 += temp.get(i).cg1;
                averageRow.cg2 += temp.get(i).cg2;
                averageRow.cg3 += temp.get(i).cg3;
                averageRow.cg4 += temp.get(i).cg4;
                averageRow.cg5 += temp.get(i).cg5;
                averageRow.cg6 += temp.get(i).cg6;
                averageRow.cg7 += temp.get(i).cg7;
                averageRow.cg8 += temp.get(i).cg8;
                averageRow.cg9 += temp.get(i).cg9;

                i++;
            }

            averageRow.cg1 = averageRow.cg1/k;
            averageRow.cg2 = averageRow.cg2/k;
            averageRow.cg3 = averageRow.cg3/k;
            averageRow.cg4 = averageRow.cg4/k;
            averageRow.cg5 = averageRow.cg5/k;
            averageRow.cg6 = averageRow.cg6/k;
            averageRow.cg7 = averageRow.cg7/k;
            averageRow.cg8 = averageRow.cg8/k;
            averageRow.cg9 = averageRow.cg9/k;

            table.add(averageRow);

            if (i<temp.size()) // проверяем, есть ли у нас ещё элементы в списке,
                //и если есть, изменяем контрольное значение idMean
                idMean = temp.get(i).id;
        }
        //Проверка работы метода
        System.out.println();
        for (i=0; i<table.size(); i++)
            System.out.println(table.get(i).toString());
    }

}

