package com.work;

import java.util.*;

public class mapdemo {
    public static void main(String[] args) {
        //学习map
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("a",12);
        map1.put("a",172);
        map1.put("d",152);
        map1.put("e",142);
        map1.put("f",112);
        System.out.println(map1);
        System.out.println(map1.size());
        System.out.println(map1.get("d"));
        System.out.println(map1.remove("e"));
        System.out.println(map1.containsKey("c"));

        Set<String> key11 = map1.keySet();//获取所有key放到Set集合key11中
        for (String s : key11) {
            System.out.println(s);
        }

        Collection<Integer> value11 = map1.values();//获取所有value放到Collection集合value11中

        Map<String,Integer> map2 = new LinkedHashMap<>();
        map2.put("a",12);
        map2.put("k",172);
        map2.put("d",152);
        map2.put("e",142);
        map2.put("a",112);
        System.out.println(map2);
    }
}
