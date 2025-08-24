package com.work;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public static int longestsubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int m = s.length();

        int left = 0;
        int right = 1;
        int maxlength = 1;

        for (right = 1; right < m; right++) {
            char n = s.charAt(right);
            for (int k = left; k < right; k++) {
                if (s.charAt(k) == n){
                    left= k+1;//移动到重复字符的下一位，不能用left++
                    break;
                }
            }
        maxlength = Math.max(maxlength,right-left+1);
        }

        return maxlength;
    }
}
