package ru.vsu.math.java.core;

import java.util.Comparator;

/**
 * Created by Dima on 05.10.14.
 */
public class RowExcel {

    protected double id;
    protected double cg1;
    protected double cg2;
    protected double cg3;
    protected double cg4;
    protected double cg5;
    protected double cg6;
    protected double cg7;
    protected double cg8;
    protected double cg9;

    public RowExcel(double id){
        this.id = id;
    }
    public RowExcel(double id, double cg1, double cg2, double cg3, double cg4,
                    double cg5, double cg6, double cg7, double cg8, double cg9){

        this.id = id;
        this.cg1 = cg1;
        this.cg2 = cg2;
        this.cg3 = cg3;
        this.cg4 = cg4;
        this.cg5 = cg5;
        this.cg6 = cg6;
        this.cg7 = cg7;
        this.cg8 = cg8;
        this.cg9 = cg9;

    }

    public String toString(){
        return "\n" + id + " " + cg1 + " " + cg2 + " " + cg3 + " " + cg4 + " " + cg5 + " " + cg6 + " " + cg7 + " " + cg8 + " " + cg9  ;
    }
}
