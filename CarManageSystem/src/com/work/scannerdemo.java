package com.work;

import java.util.Scanner;
public class scannerdemo {
    public static void main(String[] args) {
        mainproject();

    }

    public static void mainproject() {

        Scanner a = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String name = a.next();
        System.out.println("hello"+name);

        System.out.println("请输入你的年龄");
        int age = a.nextInt();
        System.out.println("你的年龄是"+age);

    }
}
