package com.work.dynamic;

public class mincostclimb {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(plt(cost));
    }

    public static int plt(int[] cost){
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < len+1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[len];
    }
}
