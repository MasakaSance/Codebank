package com.work.collection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class colllection2 {
    public static void main(String[] args) {
        //实现list系列集合功能
        List<String> names = new ArrayList<>();//经典代码要记住！！

        names.add("a1");
        names.add("a2");
        names.add("b1");
        names.add("b2");
        names.add("b3");

        //第三个位置插入c1
        names.add(2,"c1");

        names.remove(0);

        names.set(3,"d2");

        names.get(1);

        System.out.println(names);
        System.out.println("===========================================");


        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("===========================================");

        ArrayList<String> n = new ArrayList<>();

        LinkedList<String> m = new LinkedList<>();
        m.add("a1");
        m.add("a2");
        m.add("b1");
        m.add("b2");
        m.add("b3");

        System.out.println(m);
        System.out.println("===========================================");

        //尝试设计栈
        LinkedList<String> stack = new LinkedList<>();

        stack.push("one");
        stack.push("two");
        stack.addFirst("three");
        stack.addFirst("four");

        System.out.println(stack);

        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());
    }
}
