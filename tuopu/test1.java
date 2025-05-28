package com.work.tuopu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        Collection<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        //集合大小
        System.out.println(list1.size());

        //删除集合元素
        list1.remove("a");

        //判断是否空集合
        System.out.println(list1.isEmpty());

        //判断集合中包括某个数据
        System.out.println(list1.contains("b"));

        //集合转数组
        Object arr = list1.toArray();
//        System.out.println(Arrays.toString());

    }
}
