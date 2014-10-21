package ru.vsu.math.java.core;

import java.util.Comparator;

/**
 * Created by Dima on 21.10.14.
 */
public class SortedById implements Comparator<RowExcel>{

    @Override
    public int compare(RowExcel rowExcel1, RowExcel rowExcel2) {
        double id1 = rowExcel1.getId();
        double id2 = rowExcel2.getId();
        if(id1 < id2){
            return -1;
        }
        else if(id1 > id2){
            return 1;
        }
        else {
            return 0;
        }
    }
}
