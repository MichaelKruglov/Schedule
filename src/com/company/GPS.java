package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class GPS {

    final Random random = new Random();
    private ArrayList<Tool> tools1 = new ArrayList<Tool>();
    private ArrayList<Tool> tools2 = new ArrayList<Tool>();
    //Токарные ребята
    public Machine machine11;//возможно эти аргументы типа public
    public Machine machine12;
    //Фрезерные ребята
    public Machine machine21;
    public Machine machine22;
    public static int Tp11, Tp12,Tp21,Tp22;

    public GPS(){
        createTools1();
        createTools2();
        calculateGPS();
    }


    public void calculateGPS(){



        //Формируем ГПС
        int[] operations11 = {1,2,5};
        machine11 = new Machine(1,tools1.get(0),tools1.get(1),tools1.get(2),tools1.get(3),tools1.get(4),tools1.get(7),operations11 );
        int[] operations12 = {3,4,0};
        machine12 = new Machine(1,tools1.get(13),tools1.get(14),tools1.get(15),tools1.get(16),tools1.get(17),tools1.get(19),operations12 );
        int[] operations21 = {6,8,0};
        machine21 = new Machine(2,tools2.get(4),tools2.get(5),tools2.get(7),tools2.get(9),tools2.get(8),tools2.get(2),operations21 );
        int[] operations22 = {7,9,10};
        machine22 = new Machine(2,tools2.get(10),tools2.get(11),tools2.get(12),tools2.get(13),tools2.get(15),tools2.get(16),operations22 );


    }


    private void createTools1(){
            for (int i = 0; i < 10; i++) {
                Tool tool = new Tool(1, i, i,50+random.nextInt(70-50));
                tools1.add(tool);
            }
            for (int i = 0; i < 10; i++) {
                 Tool tool = new Tool(1, 10+i, i,50+random.nextInt(70-50));
                tools1.add(tool);
        }
        }

    private void createTools2(){
        for (int i = 0; i < 10; i++) {
            Tool tool = new Tool(2, 20+i, i,50+random.nextInt(70-50));
            tools2.add(tool);
        }
        for (int i = 0; i < 10; i++) {
            Tool tool = new Tool(2, 30+i, i,50+random.nextInt(70-50));
            tools2.add(tool);
        }
    }

    public  void resetServePeriods(Machine machine,int numberOfMachine){
      switch (numberOfMachine){
          case 1: this.machine11 = machine;
                  break;
          case 2: this.machine12 = machine;
                  break;
          case 3: this.machine21 = machine;
                  break;
          case 4: this.machine22 = machine;
                  break;
      }
    }

    public void resetMachine(int numberOfMachine) {
        switch (numberOfMachine) {
            case 1:
            for (int i = 0; i < 6; i++) {
                if (machine11.getTool(i).getServicePeriod() < 50) {
                    int switchable = machine11.getTool(i).getKind();
                    machine11.changeTool(i, tools1.get(switchable + 10));
                    Tp11 +=10;
                }
            }
            break;
            case 2:
                for (int i = 0; i < 6; i++) {
                    if (machine12.getTool(i).getServicePeriod() < 50) {
                        int switchable = machine12.getTool(i).getKind();
                        machine12.changeTool(i, tools1.get(switchable));
                        Tp12+=10;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 6; i++) {
                    if (machine21.getTool(i).getServicePeriod() < 50) {
                        int switchable = machine21.getTool(i).getKind();
                        machine21.changeTool(i, tools2.get(switchable + 10));
                        Tp21+=10;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < 6; i++) {
                    if (machine22.getTool(i).getServicePeriod() < 50) {
                        int switchable = machine22.getTool(i).getKind();
                        machine22.changeTool(i, tools2.get(switchable));
                        Tp22+=10;
                    }
                }
                break;
        }
    }

    public ArrayList<Tool> gettools1(){
        return tools1;
    }

}
