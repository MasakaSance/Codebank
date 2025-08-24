package daimasuixiang;

import java.util.HashSet;

public class wuchongfuzichuan {
    public static void main(String[] args) {
        String s = "abcdefdas";
        System.out.println(fuc(s));
    }
    public static int fuc(String s){
        HashSet<Character> set = new HashSet<>();
        int maxlength = 0;
        int right = 0;
        int left = 0;

        while (right<s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                maxlength = Math.max(maxlength, set.size());
            }else{
                set.remove(s.charAt(left++));
            }
        }

        return maxlength;

    }
}
