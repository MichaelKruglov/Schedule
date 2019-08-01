package com.company;

public class Tool {

    private int type; //тип станка, на котором инстру 1-токарный, 2-фрезерный
    private int id;
    private int servicePeriod;
    private int kind;

    public Tool(int type,int id, int kind, int servicePeriod){
        this.type = type;
        this.id = id;
        this.servicePeriod = servicePeriod;
        this.kind = kind;

    }

    public int getId(){return id;}

    public int getServicePeriod(){return servicePeriod;}

    public int getKind(){return kind;}

    public void serve(int time){
      this.servicePeriod = this.servicePeriod-time;
    }

}



