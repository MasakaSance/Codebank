package daimasuixiang;

import java.util.HashSet;
import java.util.Set;

public class shuzujiaoji {
    public static void main(String[] args) {
        int[] nums1= {1,2,3,5,45,32};
        int[] nums2= {5,11,56,2};
        Set result = samecontain(nums1,nums2);
        System.out.println(result);
    }

    public static Set samecontain(int[] a,int[] b){
        Set<Integer> hash1 = new HashSet<>();
        int n = a.length;
        int m = b.length;
        Set<Integer> hash2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hash1.add(a[i]);
        }

        for (int i = 0; i < hash1.size(); i++) {
            for (int j = 0; j < m; j++) {
                if (hash1.contains(b[j])){
                    hash2.add(b[j]);
                }
            }
        }

        return hash2;

    }
}
