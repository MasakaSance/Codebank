package com.work.shuzu;

public class jieyushui {
    public static void main(String[] args) {

    }
    public static int maxarea(int[] height){
        int maxrain = 0;
        int mlength = height.length;

        //左右指针表示 left right
        for (int i = 0; i < mlength; i++) {
            for (int j = i+1; j < mlength; j++) {
                maxrain = Math.max(maxrain,countrain(height,i,j));
            }
        }
        return maxrain;
    }

    public static int countrain(int[] height,int left,int right){
        int countrainy = 0;
        int minnum = Math.min(height[left],height[right]);
        countrainy = (right-left)*minnum;
        return countrainy;
    }
}
