package com.work.calc;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        ca();
    }

    public static void ca(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数据");
        int a = sc.nextInt();
        System.out.println("请输入第二个数据");
        int b = sc.nextInt();
        System.out.println("请选择进行的操作+-*/");
        String s = sc.next();
        System.out.println("结果为"+model(a,b,s));
    }

    public static int model(int a,int b,String s){
        int c = 0;
        if ("+".equals(s)){
            c = a+b;
        }
        if ("-".equals(s)){
            c = a-b;
        }
        if ("*".equals(s)){
            c=a*b;
        }
        if ("/".equals(s)){
            c=a/b;
        }
        return c;
    }
}
