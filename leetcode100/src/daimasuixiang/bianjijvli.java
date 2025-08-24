package daimasuixiang;

public class bianjijvli {
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(mindistance(s1,s2));
    }

    public static int mindistance(String s1, String s2){
        int str1 = s1.length();
        int str2 = s2.length();
        int[][] dp = new int[str1+1][str2+1];
        //str=9 dp长度10x10 dp最大[9][9]

        //初始化
        for (int i = 0; i < str1+1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < str2+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < str1+1; i++) {
            for (int j = 1; j < str2+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }

        return dp[str1][str2];
    }
}
