package com.work.shuzu;

public class findmid {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findmids(nums1,nums2));
    }
    public static double findmids(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int sum = m + n;
        int[] news = new int[sum];

        int a = 0; // nums1 的指针
        int b = 0; // nums2 的指针

        for (int i = 0; i < sum; i++) {
            if (a < m && b < n && nums1[a] <= nums2[b]) {
                news[i] = nums1[a++];
            } else if (a < m && b < n && nums1[a] > nums2[b]) {
                news[i] = nums2[b++];
            } else if (b < n) {
                news[i] = nums2[b++];
            } else {
                news[i] = nums1[a++];
            }
        }

        if (sum % 2 == 0) {
            return ((double) news[(sum / 2) - 1] + (double) news[sum / 2]) / 2;
        } else {
            return (double) news[sum / 2];
        }
    }
}
