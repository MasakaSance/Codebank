package com.work.shuzu;
//最大连续子数组和
public class shuzu1 {
    public static void main(String[] args) {
        int[] numss = {-57,9,-72,-72,-62,45,-97,24,-39,35,-82,-4,-63,1,-93,42,44,1,-75,-25,-87,-16,9,
                -59,20,5,-95,-41,4,-30,47,46,78,52,74,93,-3,53,17,34,-34,34,-69,-21,-87,-86,-79,56,-9,
                -55,-69,3,5,16,21,-75,-79,2,-39,25,72,84,-52,27,36,98,20,-90,52,-85,44,94,25,51,-27,37,
                5,-66,58,88,82,96,18,-64,7,-53,-23,-31,69,-71,47,-88,-83,98,86,39,-35,-34,-70,82,-60,-36,-30,6,-26,-85,
                55,55,-75,-10,44,84,-37,-38,-80,69,-15,-27,-85,-69,-21,61,-57,-5,59,-71,-66,-98,-5,-59,60,11,4,-93,93,
                54,98,48,9,99,-85,-70,83,-23,-32,79,-77,52,-47,-63,60,8,97,-97,-97,33,-92,-87,11,-21,-47,-29,66,33,-45,};
        System.out.println(maxsubarray(numss));

    }

    public static int maxsubarray(int[] nums){
        int n = nums.length;
        int max = findMax(nums);
        int a = 0;

        for (int start = 0; start < n; start++) {
            for (int k = 1; k < n && start+k<n; k++) {
                nums[start] = nums[start]+nums[start+k];
                int sum = findMax(nums);
                a++;
                if (sum > max){
                    max = sum;
                 }
                System.out.println(max);
                System.out.print("");

            }
        }
        System.out.println("a"+"="+a);

       return max;

    }

    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
