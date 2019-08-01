package com.company;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
/*
        ArrayList<Detail> details = new ArrayList<Detail>();
        Detail detail1 = new Detail(1,1,3); details.add(detail1);
        Detail detail2 = new Detail(2,2,4); details.add(detail2);
        Detail detail3 = new Detail(3,1,5); details.add(detail3);
        Detail detail4 = new Detail(4,6,7); details.add(detail4);
        Detail detail5 = new Detail(5,8,9); details.add(detail5);


        GPS gps = new GPS();
        for (int k=0;k<gps.machine11.tools.size();k++) {
            System.out.println(gps.machine11.getTool(k).getId());
            System.out.println(gps.machine11.getTool(k).getServicePeriod());
        }
        System.out.println("\n");

        Schedule s1 = new Schedule(details, gps.machine11);
        s1.buildQueue1();
        Machine machine1 = s1.getMachine();
        gps.resetServePeriods(machine1, 1);
        gps.resetMachine(1);
        s1.buildQueue2();
        List<Detail> schedule1 = s1.calculateSchedule(1);
*/
        Reader r = new Reader("Склад");
        r.setResizable(false);
        r.setVisible(true);
        r.setSize(550,350);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLocationRelativeTo(null);

/*
        for (int k=0;k<machine1.tools.size();k++) {
            System.out.println(machine1.getTool(k).getId());
            System.out.println(machine1.getTool(k).getServicePeriod());
        }
*/

    }
}
