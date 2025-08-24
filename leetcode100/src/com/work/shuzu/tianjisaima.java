package com.work.shuzu;

import java.util.Arrays;

public class tianjisaima {
    public static void main(String[] args) {
        int[] a = {1,2,5,7,8,6};
        int[] b = {2,4,5,8,9,6};
        System.out.println(saima(a,b));
    }
    public static int saima(int[] a,int[] b){
        Arrays.sort(a);
        Arrays.sort(b);

        int winsum = 0;
        int losesum = 0;
        int amax = a.length-1;
        int bmax = b.length-1;

        while (amax>=0 && bmax >=0){
            if(a[amax]>b[bmax]) {
                winsum++;
                amax--;
                bmax--;
            }else {
                bmax--;
            }
        }

        return winsum;
    }
}
