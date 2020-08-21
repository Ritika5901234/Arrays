package strings;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LongestSubstringWithoutRepeating {

    public static void main(String[] args){

        try{
            assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
            assertEquals(lengthOfLongestSubstring("bbbbbbbb"),1);
            assertEquals(lengthOfLongestSubstring("pwwkew"),3);
        } catch(AssertionError e){
            String message = e.getMessage();
            System.out.println(e);
        }
    }

    static int lengthOfLongestSubstring(String s){

        int max_length = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int last_unique = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                last_unique = Math.max(map.get(s.charAt(i)), i);
            }
            max_length = Math.max(max_length, i-last_unique+1);
            map.put(s.charAt(i),i+1);
        }

        return max_length;


    }
}
