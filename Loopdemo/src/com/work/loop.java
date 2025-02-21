package com.work;

public class loop {
    public static void main(String[] args) {
        printNumbers();
    }

    public static void printNumbers() {
        int n = 9;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
