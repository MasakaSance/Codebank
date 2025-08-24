package daimasuixiang;

import org.junit.Test;

public class zuichanghuiwen {
    public static void main(String[] args) {
        String a = "asdfds";
        System.out.println(huiwen(a));
    }

    public static String huiwen(String a){
        int n = a.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxlength = 1;

        if (a == null || a.length()==0) return null;

        if (a.length() == 1) return a;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n-1; i++) {
            if (a.charAt(i) == a.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <=n-len ; i++) {
                int j = i+len-1;
                if (a.charAt(i) == a.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    start = i;
                    maxlength = len;
                }
            }
        }

        return a.substring(start,start+maxlength);


    }

}
