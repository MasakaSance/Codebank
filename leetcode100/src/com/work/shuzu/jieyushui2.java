package com.work.shuzu;

public class jieyushui2 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
    public static int trap(int[] height){
        int l = height.length;
        int count = 0;
        if (l == 0 || l ==1 || l==2) return count;

        for (int i = 1; i < l-1; i++) {
            int left = i-1;
            int leftmax = 0;
            int right = i+1;
            int rightmax = 0;

            for (int j = left; j >= 0 ; j--) {
                leftmax = Math.max(leftmax,height[j]);
            }
            for (int k = right; k < l; k++) {
                rightmax = Math.max(rightmax,height[k]);
            }

            int min = Math.min(leftmax,rightmax);
            if (leftmax > height[i] && rightmax > height[i]) count = count+min-height[i];
        }

        return count;
    }
}
