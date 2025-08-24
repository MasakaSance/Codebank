package daimasuixiang;

public class huiwenzichuan {
    public static void main(String[] args) {
        String s = "asdfdfef";
        System.out.println(longstr(s));
    }
    public static int longstr(String s){
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int res = 0;

        for (int i = m-1; i >=0 ; i--) {
            for (int j = i; j < m; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<=1 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
