package com.work.shuzu;

import java.util.Arrays;
import java.util.Comparator;

public class shuzu3 {
    public static void main(String[] args) {
        int[][] m = {{1,3},{6,8},{2,4}};
        merge(m);

    }

    public static int[][] merge(int[][] intervals){
        int n = intervals.length;
        int[][] lastarray = new int[n][2];

        //先对每个数组的第一个数按大小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int[] row :intervals ) {
            System.out.println(Arrays.toString(row));
        }

        int[] fre = new int[2];

        for (int i = 0; i < n-1; i++) {
            //无交集
            if (intervals[i][1] < intervals[i+1][0]){
                lastarray[i] = intervals[i];
            }

            //有交集
            if (intervals[i][1] > intervals[i+1][0] &&
                    intervals[i][1] <= intervals[i+1][1]){
                lastarray[i][0] = intervals[i][0];
                lastarray[i][1] = intervals[i+1][1];
            }

            if (intervals[i][0] < intervals[i+1][0] &&
                    intervals[i+1][1] < intervals[i][1]){
                lastarray[i][0] = intervals[i][0];
                lastarray[i][1] = intervals[i][1];
            }
        }
        for (int[] row :lastarray ) {
            System.out.println(Arrays.toString(row));
        }

        return lastarray;
    }

}
