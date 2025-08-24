package com.work.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums == null || nums[0] > 0 || nums.length < 3) return result;

            int left = i+1;
            int right = nums.length-1;
            while (left != right && left < right){
                if(nums[i]+nums[left]+nums[right]>0) right--;
                if(nums[i]+nums[left]+nums[right]<0) left++;
                if(nums[i]+nums[left]+nums[right]==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (right > left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;
                }
            }

        }
        return result;
    }

    public static List<List<Integer>> threesumyes(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        // 边界条件检查
        if (nums == null || nums.length < 3) return result;

        // 排序数组
        Arrays.sort(nums);

        // 遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到和为 0 的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的 nums[left] 和 nums[right]
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 和小于 0，左指针右移
                } else {
                    right--; // 和大于 0，右指针左移
                }
            }
        }

        return result;
    }
}
