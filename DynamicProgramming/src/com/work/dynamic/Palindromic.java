package com.work.dynamic;

public class Palindromic {

    public static void main(String[] args) {
        String s = "asdfsdfkkjdklfadcfcda";
        longestpalindrome(s);
        System.out.println(longestpalindrome(s));
    }

    public static String longestpalindrome(String s) {
        int n = s.length();
        String sub1 = new String(s);
        String sub2 = new String(s);
        int a = 1;
        int b = 0;
        int c = 0;
        int d = 0;


        if (s == null || s.length() == 0){
            return "";
        }

        if (s.length() == 1){
            return s;
        }

        if (s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return s;
        }

        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return s.substring(0);
        }

        String sublength1 = "";
        if (s.length() >= 3) {
            for (int i = 0; i < n; i++) {
                String tmp = helper(s, i, i);
                if (tmp.length() > sublength1.length()) {
                    sublength1 = tmp;
                }

                tmp = helper(s, i, i + 1);
                if (tmp.length() > sublength1.length()) {
                    sublength1 = tmp;
                }
            }
        }return sublength1;
    }


    public static String helper(String s, int start, int end) {
        int n = s.length();
        while (start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}
