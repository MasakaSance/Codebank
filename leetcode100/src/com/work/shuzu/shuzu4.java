package com.work.shuzu;

public class shuzu4 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] leadx = new int[n];
        int[] endx = new int[n];
        //System.arraycopy(nums,0,numss,0,nums.length);
        int a = 1;
        leadx[0] = 1;
        leadx[1] = nums[0];
        endx[n-1] = 1;
        endx[n-2] = nums[n-1];

        //计算前缀积
        for(int i = 2; i < n ; i++){
            leadx[i] = 1;
            for(int j = 0; j < i ; j++){
                leadx[i] = leadx[i]*nums[j];
            }
        }

        //结算后缀积
        for(int i = 0; i < n-2 ; i++){
            endx[i] = 1;
            for(int j = i+1; j < n ; j++){
                endx[i] = endx[i]*nums[j];
            }
        }

        //交叉
        for(int i = 0 ; i < n; i++){
            answer[i] = leadx[i]*endx[i];
        }

        return answer;

    }
}
