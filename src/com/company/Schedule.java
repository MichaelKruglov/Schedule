package com.company;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schedule  {

    private  List<Detail> schedule = new ArrayList<>();
    public  ArrayList<Detail> queue1 = new ArrayList<>();
    public  ArrayList<Detail> queue2 = new ArrayList<>();
    private ArrayList<Detail> details;
    private Machine machine;

    public Schedule (ArrayList<Detail> details, Machine machine) {
        this.machine = machine;
        this.details = details;

    }

    public ArrayList<Detail> buildQueue1(){
       for (int i=0; i<details.size();i++){
            Detail currentDet = details.get(i);
            //Определяем какие детали идут на станок
            if (currentDet.getKindOfOperation1().getId() == machine.getOperation(0) || currentDet.getKindOfOperation1().getId() == machine.getOperation(1) || currentDet.getKindOfOperation1().getId() == machine.getOperation(2)){
                queue1.add(currentDet);
                
                //Вычитаем срок службы
                for (int j=0; j<this.machine.tools.size();j++){
                    //сравниваем тип инструмента на станке и тип инструмента в операции детали
                  if (this.machine.getTool(j).getKind() == currentDet.getKindOfOperation1().getToolkind1()){
                      this.machine.getTool(j).serve(currentDet.getKindOfOperation1().getTime1());
                  }
                  else if (this.machine.getTool(j).getKind() == currentDet.getKindOfOperation1().getToolkind2()){
                      this.machine.getTool(j).serve(currentDet.getKindOfOperation1().getTime2());
                  }
                  else if(this.machine.getTool(j).getKind() == currentDet.getKindOfOperation1().getToolkind3()){
                      this.machine.getTool(j).serve(currentDet.getKindOfOperation1().getTime3());
                  }
                  else if(this.machine.getTool(j).getKind() == currentDet.getKindOfOperation1().getToolkind4()){
                      this.machine.getTool(j).serve(currentDet.getKindOfOperation1().getTime4());
                  }
                }

            }

        }
        return queue1;
    }

    public ArrayList<Detail> buildQueue2(){
        for (int i=0; i<details.size();i++){
            Detail currentDet = details.get(i);
            //Определяем какие детали идут на станок
            if (currentDet.getKindOfOperation2().getId() == machine.getOperation(0) || currentDet.getKindOfOperation2().getId() == machine.getOperation(1) || currentDet.getKindOfOperation2().getId() == machine.getOperation(2)){
                queue2.add(currentDet);
                //Вычитаем срок службы
                for (int j=0; j<this.machine.tools.size();j++){
                    //сравниваем тип инструмента на станке и тип инструмента в операции детали
                    if (this.machine.getTool(j).getKind() == currentDet.getKindOfOperation2().getToolkind1()){
                        this.machine.getTool(j).serve(currentDet.getKindOfOperation2().getTime1());
                    }

                    else if (this.machine.getTool(j).getKind() == currentDet.getKindOfOperation2().getToolkind2()){
                        this.machine.getTool(j).serve(currentDet.getKindOfOperation2().getTime2());
                    }
                    else if(this.machine.getTool(j).getKind() == currentDet.getKindOfOperation2().getToolkind3()){
                        this.machine.getTool(j).serve(currentDet.getKindOfOperation2().getTime3());
                    }
                    else if(this.machine.getTool(j).getKind() == currentDet.getKindOfOperation2().getToolkind4()){
                        this.machine.getTool(j).serve(currentDet.getKindOfOperation2().getTime4());
                    }
                }

            }
        }
        return queue2;
    }

    public  List<Detail> calculateSchedule(int method){


        switch (method) {
            case 1:
              queue1.sort(Comparator.comparing(Detail::getTime1));
              queue2.sort(Comparator.comparing(Detail::getTime2));
              break;

            case 2:
                queue1.sort(Comparator.comparing(Detail::getTime1).reversed());
                queue2.sort(Comparator.comparing(Detail::getTime2).reversed());
                break;

            case 3:
                queue1.sort(Comparator.comparing((Detail::getTotalTime)));
                queue2.sort(Comparator.comparing(Detail::getTime2));
        }
        schedule = ListUtils.union(queue1, queue2);
        return schedule;
    }

    public Machine getMachine(){
        return this.machine;
    }

}
