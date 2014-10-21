package ru.vsu.math.java.core;

import java.util.Comparator;

/**
 * Created by Dima on 05.10.14.
 */
public class RowExcel {


    private double id;
    private double cg1;
    private double cg2;
    private double cg3;
    private double cg4;
    private double cg5;
    private double cg6;
    private double cg7;
    private double cg8;
    private double cg9;


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

    public double getId(){
        return this.id;
    }

    public void setId(double id){
        this.id = id;
    }

    public double getCG1(){
        return this.cg1;
    }
    public void setCG1(double cg1){
        this.cg1 = cg1;
    }

    public double getCG2(){
        return this.cg2;
    }
    public void setCG2(double cg2){
        this.cg2 = cg2;
    }

    public double getCG3(){
        return this.cg3;
    }
    public void setCG3(double cg3){
        this.cg3 = cg3;
    }

    public double getCG4(){
        return this.cg4;
    }
    public void setCG4(double cg4){
        this.cg4 = cg4;
    }

    public double getCG5(){
        return this.cg5;
    }
    public void setCG5(double cg5){this.cg5 = cg5;}

    public double getCG6(){
        return this.cg6;
    }
    public void setCG6(double cg6){
        this.cg6 = cg6;
    }

    public double getCG7(){
        return this.cg7;
    }
    public void setCG7(double cg7){
        this.cg7 = cg7;
    }

    public double getCG8(){
        return this.cg8;
    }
    public void setCG8(double cg8){
        this.cg8 = cg8;
    }

    public double getCG9(){
        return this.cg9;
    }
    public void setCG9(double cg9){
        this.cg9 = cg9;
    }

    public String toString(){
        //return "\n" + id + "." + " " + name;
        return "\n" + id + " " + cg1 + " " + cg2 + " " + cg3 + " " + cg4 + " " + cg5 + " " + cg6 + " " + cg7 + " " + cg8 + " " + cg9  ;
    }

}
