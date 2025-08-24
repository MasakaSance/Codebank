package daimasuixiang;

public class zimuyiweici {
    public static void main(String[] args) {
        String s1 = "asdfsd";
        String s2 = "dsfasd";
        boolean c= checkword(s1,s2);
        System.out.println(c);
    }

    public static boolean checkword(String a,String b){
        int[] record = new int[26];
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n; i++) {
            record[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            record[b.charAt(i) - 'a']--;
        }

        for (int p : record){
            if (p != 0){
                return false;
            }
        }
        return true;
    }
}
