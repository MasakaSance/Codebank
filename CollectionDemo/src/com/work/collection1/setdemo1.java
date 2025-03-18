package com.work.collection2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class setdemo1 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("diyige");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("youxu");

        Set<Double> set3 = new TreeSet<>();
        set3.add(1.0);
        set3.add(1457.0);
        set3.add(12.0);

        System.out.println("===================");

        String s1 = "asd";
        String s2 = "asdsd";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


    }
}
