package com.company;

import com.sun.imageio.stream.StreamCloser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReadDet extends JFrame {

    private JLabel l1,l2,l3;
    private JTextField t1,t2,t3;
    private JButton b;
    private eHandlerDet handler = new eHandlerDet();

    public ReadDet(String s) {
        super(s);
        setLayout(null);
        JLabel comment = new JLabel("1-5 - Токарная обр., 6-10 - Фрезерование");
        comment.setBounds(100,0,300,50);
        l1 = new JLabel("Номер");
        l1.setBounds(50,50,100,50);
        l2 = new JLabel("Тип операции 1");
        l2.setBounds(150,50,100,50);

        l3 = new JLabel("Тип операции 2");
        l3.setBounds(270,50,100,50);


        t1 = new JTextField(7);
        t1.setBounds(10,100,120,20);
        t2 = new JTextField(7);
        t2.setBounds(140,100,120,20);

        t3 = new JTextField(7);
        t3.setBounds(270,100,120,20);

        b = new JButton("Создать");
        b.setBounds(150,140,100,20);
        add(comment);
        add(l1);
        add(l2);

        add(l3);

        add(t1);
        add(t2);

        add(t3);

        add(b);
        b.addActionListener(handler);
    }

    public class eHandlerDet implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b) {
               Detail detail = new Detail(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()));

               }
        }
    }
}
