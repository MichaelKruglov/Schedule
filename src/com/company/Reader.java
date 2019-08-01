package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Reader extends JFrame {


    private JButton buttons[] = new JButton[100];
    private eHandler handler = new eHandler();
    private JButton schedule = new JButton("Составить расписание");
    private JTextField methodB = new JTextField(4);
    private JLabel methodL = new JLabel("Выберите метод расчета");
    private JLabel averageTime = new JLabel("Среднее время пребывания детали в системе:");





    public Reader(String s) {
        super(s);
        setLayout(null);
       int n =  Integer.parseInt(JOptionPane.showInputDialog("Введите кол-во деталей"));

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                buttons[x*2+y+1] = new JButton("Деталь " + (x*2+y+1));
                buttons[x*2+y+1].setBounds(x*(70+30)+20, y*(20+10)+50,100,20);

                add(buttons[x*2+y+1]);
                buttons[x*2+y+1].addActionListener(handler);
            }
        }
        add(schedule);
        schedule.addActionListener(handler);
        schedule.setBounds(160, 200,200,20);
        add(methodB);
        methodB.setBounds(230, 10,100,20);
        add(methodL);
        methodL.setBounds(80,10,200,20);
        averageTime.setBounds(20,250,500,20);
        add(averageTime);

    }

    public class eHandler  implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //Создаем деталь
            if (e.getSource() != schedule){
                ReadDet det = new ReadDet("Деталь № " );
                det.setResizable(false);
                det.setVisible(true);
                det.setSize(400,200);
                det.setLocationRelativeTo(null);
            }
           else if (e.getSource() == schedule){

                //Строим расписание
                ArrayList<Detail> details = Detail.getList();
                int method = Integer.parseInt(methodB.getText());

                GPS gps = new GPS();
                int[] operations = {1,1,1};
                Machine machine1initial = new Machine(1,gps.machine11.getTool(0),gps.machine11.getTool(1),gps.machine11.getTool(2),gps.machine11.getTool(3),gps.machine11.getTool(4),gps.machine11.getTool(5),operations);
                Machine machine2initial = new Machine(1,gps.machine12.getTool(0),gps.machine12.getTool(1),gps.machine12.getTool(2),gps.machine12.getTool(3),gps.machine12.getTool(4),gps.machine12.getTool(5),operations);
                Machine machine3initial = new Machine(2,gps.machine21.getTool(0),gps.machine21.getTool(1),gps.machine21.getTool(2),gps.machine21.getTool(3),gps.machine21.getTool(4),gps.machine21.getTool(5),operations);
                Machine machine4initial = new Machine(2,gps.machine22.getTool(0),gps.machine22.getTool(1),gps.machine22.getTool(2),gps.machine22.getTool(3),gps.machine22.getTool(4),gps.machine22.getTool(5),operations);

                //1 (токарный) станок
                Schedule s1 = new Schedule(details, gps.machine11);
                s1.buildQueue1();
                Machine machine1 = s1.getMachine();
                gps.resetServePeriods(machine1, 1);
                gps.resetMachine(1);
                s1.buildQueue2();
                List<Detail> schedule1 = s1.calculateSchedule(method);

                //2 (токарный) станок
                Schedule s2 = new Schedule(details, gps.machine12);
                s2.buildQueue1();
                Machine machine2 = s2.getMachine();
                gps.resetServePeriods(machine2, 2);
                gps.resetMachine(2);
                s2.buildQueue2();
                List<Detail> schedule2 = s2.calculateSchedule(method);

                //3 (фрезерный) станок
                Schedule s3 = new Schedule(details, gps.machine21);
                s3.buildQueue1();
                Machine machine3 = s3.getMachine();
                gps.resetServePeriods(machine3, 3);
                gps.resetMachine(3);
                s3.buildQueue2();
                List<Detail> schedule3 = s3.calculateSchedule(method);

                //4 (фрезерный) станок
                Schedule s4 = new Schedule(details, gps.machine22);
                s4.buildQueue1();
                Machine machine4 = s4.getMachine();
                gps.resetServePeriods(machine4, 4);
                gps.resetMachine(4);
                s4.buildQueue2();
                List<Detail> schedule4 = s4.calculateSchedule(method);

                //Строим диаграмму Ганнта
                //Токарные станки
                JFrame frame = new JFrame("Gannt Tok");
                Gannt gannt = new Gannt();
                gannt.sendQs(s1.queue1,s1.queue2,s2.queue1,s2.queue2);
                gannt.setBackground(Color.WHITE);
                frame.add(gannt);
                frame.setSize(700,250);
                frame.setVisible(true);
                frame.setResizable(false);

                JFrame frame2 = new JFrame("Gannt Frez");
                Gannt gannt2 = new Gannt();
                gannt2.sendQs(s3.queue1,s3.queue2,s4.queue1,s4.queue2);
                gannt2.setBackground(Color.WHITE);
                frame2.add(gannt2);
                frame2.setSize(700,250);
                frame2.setVisible(true);
                frame2.setResizable(false);

                //Вывод результатов
                //Токарные ребята
                Results results1 = new Results("Results Tok", s1.queue1,s1.queue2,s2.queue1,s2.queue2,schedule1,schedule2,gps.machine11,gps.machine12,machine1initial, machine2initial, 1);
                results1.setSize(600,450);
                results1.setVisible(true);
                results1.setResizable(false);
                float average1 = results1.getAverage();

                //Фрезерные
                Results results2 = new Results("Results Frez",s3.queue1,s3.queue2,s4.queue1,s4.queue2,schedule3,schedule4,gps.machine21,gps.machine22,machine3initial, machine4initial,2);
                results2.setSize(600,450);
                results2.setVisible(true);
                results2.setResizable(false);
                float average2 = results2.getAverage();

                float average = (average1+average2)/2;
                averageTime.setText("Среднее время пребывания детали в системе: "+average);

            }
        }
    }
}
