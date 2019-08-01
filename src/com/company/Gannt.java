package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gannt extends JPanel {

    private ArrayList<Detail> q11, q12, q21, q22;


    public void paintComponent (Graphics gr){
        Graphics2D g = (Graphics2D)gr;
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3.0f));

        //Оси координат
        g.drawLine(20,10,20, 200);
        g.drawLine(20,200,600, 200);
        g.drawLine(20,100,600, 100);
        JLabel stan1 = new JLabel("I");
        stan1.setBounds(10,100,10,10);
        add(stan1);
        JLabel stan2 = new JLabel("II");
        stan2.setBounds(10,190,10,10);
        add(stan2);

        int sum2 = 0;
        int sum1 = 0;
        //Первые очереди
        for (int i = 0; i<q11.size();i++){
           g.drawRect(20+sum1*2, 80, q11.get(i).getTime1()*2,20);
           JLabel label = new JLabel(""+q11.get(i).getId());
           label.setBounds(25+sum1*2, 80, q11.get(i).getTime1()*2,20);
           add(label);
           sum1 += q11.get(i).getTime1();
        }
        for (int i = 0; i<q21.size();i++){
            g.drawRect(20+sum2*2, 180, q21.get(i).getTime1()*2,20);
            JLabel label = new JLabel(""+q21.get(i).getId());
            label.setBounds(25+sum2*2, 180, q21.get(i).getTime1()*2,20);
            add(label);
            sum2 += q21.get(i).getTime1();
        }

        //Вторые очереди
        if (sum2>sum1) {
            sum1 = sum2;
        }
        else if (sum2<sum1){
            sum2 = sum1;
        }
            for (int i = 0; i<q12.size();i++) {
                g.drawRect(20 + sum1 * 2, 80, q12.get(i).getTime2() * 2, 20);
                JLabel label = new JLabel(""+q12.get(i).getId());
                label.setBounds(25 + sum1 * 2, 80, q12.get(i).getTime2() * 2, 20);
                add(label);
                sum1 += q12.get(i).getTime2();
                }
            for (int i = 0; i<q22.size();i++){
                g.drawRect(20+sum2*2, 180, q22.get(i).getTime2()*2,20);
                JLabel label = new JLabel(""+q22.get(i).getId());
                label.setBounds(25+sum2*2, 180, q22.get(i).getTime2()*2,20);
                add(label);
                sum2 += q22.get(i).getTime2();
            }



    }

    public void sendQs(ArrayList<Detail> q11, ArrayList<Detail> q12, ArrayList<Detail> q21, ArrayList<Detail> q22){
        this.q11 = q11;
        this.q12 = q12;
        this.q21 = q21;
        this.q22 = q22;

    }


}
