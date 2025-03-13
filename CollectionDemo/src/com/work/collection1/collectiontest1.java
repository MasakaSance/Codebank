package com.work.collection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class collectiontest1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a1");
        list.add("b1");
        list.add("b2");
        list.add("b3");
        list.add("c1");
        list.add("c2");

        //需求1：删除所有b
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.contains("b")){
                iterator.remove();
//                iterator.remove(name) 会报错
                //
            }
        }

        System.out.println(list);
        System.out.println("==================================");


    }
}
