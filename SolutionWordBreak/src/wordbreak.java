import java.util.HashSet;
import java.util.Set;

public class wordbreak {
    //Given a string s and a dictionary of words dict, determine if s can be segmented into
    // a space-separated sequence of one or more dictionary words. For example, given s =
    // "leetcode", dict = ["leet", "code"]. Return true because "leetcode" can be segmented as
    // "leet code".

    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }
    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;
        for(String a: dict){
            int len = a.length();
            int end = start+len;
            //end index should be <= string length
            if(end > s.length())
                continue;
            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "matebook";
        Set<String> dict = new HashSet<String>();
        dict.add("mate");
        dict.add("book");
        System.out.println(new wordbreak().wordBreak(s, dict));
    }
}
