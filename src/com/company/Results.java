package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.GPS.*;

public class Results extends JFrame {
    private JLabel schedule1L = new JLabel("Расписание первого станка: ");
    private JLabel schedule2L = new JLabel("Расписание второго станка: ");
    private JLabel state1L = new JLabel("Состояние станка 1: ");
    private JLabel state2L = new JLabel("Состояние станка 2: ");
    private String result1 = "";
    private String result2 = "";
    private JLabel totalTimeDet1L = new JLabel("Общее время обработки T1: ");
    private JLabel Koef1 = new JLabel("Коэффициент загрузки станка K1: ");
    private JLabel totalTimeDet2L = new JLabel("Общее время обработки T2: ");
    private  JLabel Koef2 = new JLabel("Коэффициент загрузки станка K2: ");
    private float average;
    private JLabel state1kL = new JLabel("");
    private JLabel state2kL= new JLabel("");
    private JLabel times1L= new JLabel("");
    private JLabel times2L= new JLabel("");
    private JLabel times1kL= new JLabel("");
    private JLabel times2kL= new JLabel("");


    public  Results(String s, ArrayList<Detail> queue11, ArrayList<Detail>queue12, ArrayList<Detail>queue21,
                    ArrayList<Detail>queue22, List<Detail> schedule1, List<Detail> schedule2,Machine machine1, Machine machine2,
                    Machine machine1initial, Machine machine2initial, int group){
        super(s);
        setLayout(null);
        //Расписание
        add(schedule1L);
        schedule1L.setBounds(20, 20, 500, 20);
        //Начальные инстр
        state1L.setBounds(20,50,500,20);
        add(state1L);
        times1L.setBounds(20,70,500,20);
        add(times1L);
        //Конечные инстр
        state1kL.setBounds(20,100,500,20);
        add(state1kL);
        times1kL.setBounds(20,120,500,20);
        add(times1kL);
        //Параметры
        totalTimeDet1L.setBounds(20,150,500,20);
        add(totalTimeDet1L);
        Koef1.setBounds(20,170,500,20);
        add(Koef1);

        //Расписание
        add(schedule2L);
        schedule2L.setBounds(20, 220, 500, 20);
        //Начальные инстр
        state2L.setBounds(20,250,500,20);
        add(state2L);
        times2L.setBounds(20,270,500,20);
        add(times2L);
        //Конечные инстр
        state2kL.setBounds(20,300,500,20);
        add(state2kL);
        times2kL.setBounds(20,320,500,20);
        add(times2kL);
        //Параметры
        totalTimeDet2L.setBounds(20,350,500,20);
        add(totalTimeDet2L);
        Koef2.setBounds(20,370,500,20);
        add(Koef2);


        result1 = "";
        result2 = "";
        String state1 = "";
        String state2 = "";
        String state1k = "";
        String state2k = "";
        String times1 = "";
        String times2 = "";
        String times1k = "";
        String times2k = "";

        //Расчет критериев
        //Токарные станки
        int totalTimeDet1=0;
        int totalTimeDet2=0;
        int sum1 = 0;
        int sum2 = 0;
        int[] f1 = new int[10];
        int[] f2 = new int[10];
        ArrayList<Integer> F = new ArrayList<Integer>();
        int f1z = 0;
        int f2z = 0;
        //Первые очереди
        for (int i=0;i<queue11.size();i++){
            totalTimeDet1+=queue11.get(i).getTime1();
            if (i!=0) {
                f1[i] = f1[i - 1] + queue11.get(i).getTime1();
            }
            else { f1[i] = queue11.get(i).getTime1();}
        }
        for (int i=0;i<queue21.size();i++){
            totalTimeDet2+=queue21.get(i).getTime1();
            if (i!=0) {
                f2[i] = f2[i - 1] + queue21.get(i).getTime1();
            }
            else { f2[i] = queue21.get(i).getTime1();}
        }
        //Скип пробела
        if (totalTimeDet1>totalTimeDet2){
            f2z+=totalTimeDet1 - totalTimeDet2;
            sum1 = totalTimeDet1;
            sum2 = totalTimeDet1;
        }
        else if (totalTimeDet2>totalTimeDet1){
            f1z+=totalTimeDet2 - totalTimeDet1;
            sum1=totalTimeDet2;
            sum2 = totalTimeDet2;
        }

        //Вторые очереди
        for (int i=0;i<queue12.size();i++){
            totalTimeDet1+=queue12.get(i).getTime2();
            sum1+=queue12.get(i).getTime2();
            if (i!=0) {
                f1[i] = f1[i - 1] + queue12.get(i).getTime1();
            }
            else { f1[i] = f1z + queue12.get(i).getTime1();}
            F.add(sum1);
        }
        for (int i=0;i<queue22.size();i++){
            totalTimeDet2+=queue22.get(i).getTime2();
            sum2+=queue22.get(i).getTime2();
            if (i!=0) {
                f2[i] = f2[i - 1] + queue22.get(i).getTime1();
            }
            else { f2[i] = f2z+ queue22.get(i).getTime1();}
            F.add(sum2);
        }

        //Общее время обработки
        if (group==1){
            totalTimeDet1 += Tp11;
            totalTimeDet2 += Tp12;
        }
        else{
            totalTimeDet1 += Tp21;
            totalTimeDet2 += Tp22;
        }
        //коэф загрузки станков
        float k1 = (float) totalTimeDet1/sum1;
        float k2 = (float) totalTimeDet2/sum2;


        //среднее время детали в системе
        int sumF = 0;

        for(int i=0;i<F.size();i++) {
            sumF+=F.get(i);
        }
        average = (float) sumF/F.size();


        //Вывод результатов
        //Станок 1
        for (int i=0;i<schedule1.size();i++){
            result1 = result1 + schedule1.get(i).getId()+"  ";
        }
        schedule1L.setText("Расписание станка 1: "+result1.toString());
        for (int i=0;i<machine1initial.tools.size();i++){
            state1 = state1 + machine1initial.getTool(i).getId()+"   ";
            times1 = times1 + machine1initial.getTool(i).getServicePeriod()+"  ";
        }
        state1L.setText("Начальные Инструменты станка 1: "+state1.toString());
        times1L.setText("Начальные Сроки службы инстр 1: "+times1);
        for (int i=0;i<machine1.tools.size();i++){
            state1k = state1k + machine1.getTool(i).getId()+"   ";
            times1k = times1k + machine1.getTool(i).getServicePeriod()+"  ";
        }
        state1kL.setText("Конечные Инструменты станка 1: "+state1k);
        times1kL.setText("Конечные Сроки службы инстр 1: "+times1k);
        totalTimeDet1L.setText("Общее время обработки T1: " + totalTimeDet1);
        Koef1.setText("Коэффициент загрузки станка K1: " + k1);


        //Станок 2
        for (int i=0;i<schedule2.size();i++){
            result2 = result2 + schedule2.get(i).getId()+"  ";
        }
        schedule2L.setText("Расписание станка 2: "+result2.toString());
        for (int i=0;i<machine2initial.tools.size();i++){
            state2 = state2 + machine2initial.getTool(i).getId()+"  ";
            times2 = times2 + machine2initial.getTool(i).getServicePeriod()+"  ";
        }
        state2L.setText("Начальные Инструменты станка 2: "+state2.toString());
        times2L.setText("Начальные Сроки службы инстр 2: "+times2);
        for (int i=0;i<machine2.tools.size();i++){
            state2k = state2k + machine2.getTool(i).getId()+"  ";
            times2k = times2k + machine2.getTool(i).getServicePeriod()+"  ";
        }
        state2kL.setText("Конечные Инструменты станка 2: "+state2k);
        times2kL.setText("Конечные Сроки службы инстр 2: "+times2k);
        totalTimeDet2L.setText("Общее время обработки T2: " + totalTimeDet2);
        Koef2.setText("Коэффициент загрузки станка K2: " + k2);

    }

    public float getAverage(){
        return average;
    }
}
