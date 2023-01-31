package pers.helen.javabasic.concurrentprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastDemo {

    public static void main(String[] args){
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");

        for(String i : list2){
            System.out.println(i);
            if(i == "2"){
                list2.remove(i);
            }
        }

    }
}
