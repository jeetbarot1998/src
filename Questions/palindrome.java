package Questions;

import java.util.HashMap;
import java.util.Map;

public class palindrome {
    static String s = "malayalam";
    public static void main(String[] args) {
        System.out.println(isPalindrome(s));
        Map m = new HashMap();
        m.put("a", 10);
        m.put("b", 20);
        System.out.println(m.containsKey("a"));
    }

    static boolean isPalindrome(String s){
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
