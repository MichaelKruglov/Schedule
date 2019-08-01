package com.company;
import java.util.ArrayList;

public class Machine {

    private int type; //тип станка, 1-токарный, 2-фрезерный
    private Tool tool1;
    private Tool tool2;
    private Tool tool3;
    private Tool tool4;
    private Tool tool5;
    private Tool tool6;
    public ArrayList<Tool> tools = new ArrayList<Tool>();
    private int[] operations;

   public  Machine(int type, Tool tool1, Tool tool2, Tool tool3, Tool tool4, Tool tool5, Tool tool6,int[] operations) {
       this.type = type;
       this.tool1 = tool1;
       tools.add(tool1);
       this.tool2 = tool2;
       tools.add(tool2);
       this.tool3 = tool3;
       tools.add(tool3);
       this.tool4 = tool4;
       tools.add(tool4);
       this.tool5 = tool5;
       tools.add(tool5);
       this.tool6 = tool6;
       tools.add(tool6);
       this.operations = operations;
   }

    public Tool getTool(int i){
        return tools.get(i);
    }

    public int getOperation(int i){
       return operations[i];
    }

    public void changeTool(int initial,  Tool finalTool) {
        switch (initial) {
            case 0:
            this.tool1=finalTool;
            tools.set(initial,finalTool);
            break;
            case 1:
                this.tool2=finalTool;
                tools.set(initial,finalTool);
                break;
            case 2:
                this.tool3=finalTool;
                tools.set(initial,finalTool);
                break;
            case 3:
                this.tool4=finalTool;
                tools.set(initial,finalTool);
                break;
            case 4:
                this.tool5=finalTool;
                tools.set(initial,finalTool);
                break;
            case 5:
                this.tool6=finalTool;
                tools.set(initial,finalTool);
                break;
        }
    }

}
