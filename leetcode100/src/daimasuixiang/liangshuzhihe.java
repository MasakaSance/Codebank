package daimasuixiang;

public class liangshuzhihe {
    //两数之和
    public static void main(String[] args) {
        int[] nums = {2,7,11,55};
        int target = 9;
        System.out.println(counta(nums,target)[0][1]);
    }

    public static int[][] counta(int[] A,int b){
        int[][] d = new int[A.length/2][2];
        int m = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0;j != i && j < A.length; j++) {
                int c = b - A[i];
                if (c == A[j]){
                    d[m][0] = i;
                    d[m][1] = j;
                    m++;
                }
            }
        }
        return d;
    }

}


