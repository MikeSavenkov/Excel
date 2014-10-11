package ru.vsu.math.java.core;

/**
 * Created by Dima on 05.10.14.
 */
public class Table {


    private String name;
    private double id;
    private double CG1;
    private double CG2;
    private double CG3;
    private double CG4;
    private double CG5;
    private double CG6;
    private double CG7;
    private double CG8;
    private double CG9;


    public Table(double id, double CG1, double CG2, double CG3, double CG4, double CG5, double CG6, double CG7, double CG8, double CG9, String name){
        this.id = id;
        this.CG1 = CG1;
        this.CG2 = CG2;
        this.CG3 = CG3;
        this.CG4 = CG4;
        this.CG5 = CG5;
        this.CG6 = CG6;
        this.CG7 = CG7;
        this.CG8 = CG8;
        this.CG9 = CG9;
        this.name = name;
    }

    public double getId(){
        return this.id;
    }

    public void setId(double id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getCG1(){
        return this.CG1;
    }
    public void setCG1(double CG1){
        this.CG1 = CG1;
    }

    public double getCG2(){
        return this.CG2;
    }
    public void setCG2(double CG2){
        this.CG1 = CG2;
    }

    public double getCG3(){
        return this.CG3;
    }
    public void setCG3(double CG3){
        this.CG3 = CG3;
    }

    public double getCG4(){
        return this.CG4;
    }
    public void setCG4(double CG4){
        this.CG1 = CG4;
    }

    public double getCG5(){
        return this.CG5;
    }
    public void setCG5(double CG5){
        this.CG1 = CG5;
    }

    public double getCG6(){
        return this.CG6;
    }
    public void setCG6(double CG6){
        this.CG1 = CG6;
    }

    public double getCG7(){
        return this.CG7;
    }
    public void setCG7(double CG7){
        this.CG7 = CG7;
    }

    public double getCG8(){
        return this.CG8;
    }
    public void setCG8(double CG8){
        this.CG8 = CG8;
    }

    public double getCG9(){
        return this.CG9;
    }
    public void setCG9(double CG9){
        this.CG9 = CG9;
    }

    public String toString(){
        //return "\n" + id + "." + " " + name;
        return "\n" + id + " " + CG1 + " " + CG2 + " " + CG3 + " " + CG4 + " " + CG5 + " " + CG6 + " " + CG7 + " " + CG8 + " " + CG9  ;
    }
}
