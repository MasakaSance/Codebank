package com.work.dynamic;

public class fblq {
    public static void main(String[] args) {
        System.out.println(fblq(7));
    }
    public static int fblq(int n){
        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = n-2; i > 0 ; i--) {
           c = b;
           b = a;
           a = a+c;
        }

        return a;
    }
}
