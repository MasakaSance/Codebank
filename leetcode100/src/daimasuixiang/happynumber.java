package daimasuixiang;

import java.util.HashSet;
import java.util.Set;

public class happynumber {
    public static void main(String[] args) {
        int a = 456;
        boolean b = test1(a);
        System.out.println(b);
    }

    public static boolean test1(int a){
        Set<Integer> set1= new HashSet<>();
        int[] nums = new int[4];
        int k = 10;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a%k;
            a = (a - nums[i])/k;
        }

        int sum1 = 0;
        while (calc(nums) != 1){
            set1.add(calc(nums));
        }
        return true;
    }

    public static int calc(int[] b){
        int c = 0;
        c = (b[0]*2) + (b[1]*2) + (b[2]*2) + (b[3]*2);

        return c;
    }
}
