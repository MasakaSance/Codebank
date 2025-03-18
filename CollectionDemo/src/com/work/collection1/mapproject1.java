package com.work;

import java.util.*;

public class mapproject1 {
    public static void main(String[] args) {
        countmap();
        System.out.println(countmap());
    }

    public static Map countmap(){

        List<String> list1 = new ArrayList<>();
        String[] a = {"a", "b","c","d"};
        Random r = new Random();
        for (int i = 0; i < 40; i++) {
            int index = r.nextInt(a.length);
            list1.add(a[index]);
        }

        Map<String,Integer> conut1 = new HashMap<>();
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()){
            String b = iterator.next();
            if (conut1.containsKey(b)){
                int c = conut1.get(b);
                c++;
                conut1.put(b,c);
            }else {
                conut1.put(b,1);
            }

        }
        return conut1;
    }
}
