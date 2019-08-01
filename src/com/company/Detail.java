package com.company;

import java.util.ArrayList;

public class Detail {

    private int timeOf1Work;
    private Operation kindOf1Work;
    private int timeOf2Work;
    private Operation kindOf2Work;
    private int id;
    private static ArrayList<Detail> details = new ArrayList<Detail>();
   //токарные операции
    public static Operation Operation1 = new Operation(1,0,5,2,7,1,5,2,6);
    public static Operation Operation2 = new Operation(2,0,4,3,5,4,7,1,9);
    public static Operation Operation3 = new Operation(3,4,6,7,4,3,7,9,8);
    public static  Operation Operation4 = new Operation(4,3,8,4,7,6,3,5,2);
    public static Operation Operation5 = new Operation(5,1,4,2,9,7,4,7,6);
   //фрезерные операции
    public static Operation Operation6 = new Operation(6,5,5,9,6,7,5,8,2);
    public static Operation Operation7 = new Operation(7,2,7,1,4,6,5,3,7);
    public static Operation Operation8 = new Operation(8,9,7,7,3,4,6,8,6);
    public static Operation Operation9 = new Operation(9,0,5,2,7,1,5,2,6);
    public static Operation Operation10 = new Operation(10,3,5,5,7,1,5,0,6);

    Detail(int id,  int kindOf1Work,  int kindOf2Work ){
        switch (kindOf1Work){
            case 1:
                this.kindOf1Work = Operation1;
                break;
            case 2:
                this.kindOf1Work = Operation2;
                break;
            case 3:
                this.kindOf1Work = Operation3;
                break;
            case 4:
                this.kindOf1Work = Operation4;
                break;
            case 5:
                this.kindOf1Work = Operation5;
                break;
            case 6:
                this.kindOf1Work = Operation6;
                break;
            case 7:
                this.kindOf1Work = Operation7;
                break;
            case 8:
                this.kindOf1Work = Operation8;
                break;
            case 9:
                this.kindOf1Work = Operation9;
                break;
            case 10:
                this.kindOf1Work = Operation10;
                break;
        }
        this.timeOf1Work = this.kindOf1Work.getTotalTime();
        switch (kindOf2Work){
            case 1:
                this.kindOf2Work = Operation1;
                break;
            case 2:
                this.kindOf2Work = Operation2;
                break;
            case 3:
                this.kindOf2Work = Operation3;
                break;
            case 4:
                this.kindOf2Work = Operation4;
                break;
            case 5:
                this.kindOf2Work = Operation5;
                break;
            case 6:
                this.kindOf2Work = Operation6;
                break;
            case 7:
                this.kindOf2Work = Operation7;
                break;
            case 8:
                this.kindOf2Work = Operation8;
                break;
            case 9:
                this.kindOf2Work = Operation9;
                break;
            case 10:
                this.kindOf2Work = Operation10;
                break;
        }
        this.timeOf2Work = this.kindOf2Work.getTotalTime();
        this.id = id;
        details.add(this);
    }


    public int getTime1(){
        return timeOf1Work;
    }

    public Operation getKindOfOperation1(){
        return kindOf1Work;
    }

    public int getTime2(){
        return timeOf2Work;
    }

    public Operation getKindOfOperation2(){
        return kindOf2Work;
    }

    public  int getId(){
        return id;
    }

    public static ArrayList getList(){
        return details;
    }

    public int getTotalTime(){
        return timeOf1Work + timeOf2Work;
    }


}
