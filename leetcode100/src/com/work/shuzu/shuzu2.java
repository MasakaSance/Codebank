package com.work.shuzu;

public class shuzu2 {
    public static void main(String[] args) {
        start(4);
    }

    public static void start(int n){
        int[][] arr = new int[n][n];

        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        printarray(arr);

        //随机
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int random1 = (int)(Math.random()*n);
                System.out.println(random1);
                int random2 = (int)(Math.random()*n);
                System.out.println(random2);

                //临时变量fre
                int fre = arr[i][j];
                arr[i][j] = arr[random1][random2];
                arr[random1][random2] = fre;
            }
        }
        System.out.println("------------------------------------");
        printarray(arr);
    }


    public static void printarray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
