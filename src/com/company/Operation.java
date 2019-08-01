package com.company;

public class Operation {

    private  int id;  //id - профиль (1-токарный, 2-фрезерный)
    private int tool1, tool2, tool3, tool4; //ТИПЫ ИНСТРУМЕНТОВ!! А не ид
    private int time1, time2, time3, time4;
    private int totalTime;


    public Operation (int id, int tool1, int time1, int tool2, int time2, int tool3, int time3, int tool4, int time4){

        this.tool1 = tool1;
        this.tool2 = tool2;
        this.tool3 = tool3;
        this.tool4 = tool4;
        this.time1=time1;
        this.time2=time2;
        this.time3=time3;
        this.time4=time4;
        this.id = id;
        this.totalTime = time1+time2+time3+time4;

    }

    public int getId(){return id;}

    public int getToolkind1(){return tool1;}
    public int getToolkind2(){return tool2;}
    public int getToolkind3(){return tool3;}
    public int getToolkind4(){return tool4;}

    public int getTime1(){return time1;}
    public int getTime2(){return time2;}
    public int getTime3(){return time3;}
    public int getTime4(){return time4;}

    public int getTotalTime(){return totalTime;}
}
