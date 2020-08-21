package strings;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * #Medium
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args){

        try{
            assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
            assertEquals(lengthOfLongestSubstring("bbbbbbbb"),1);
            assertEquals(lengthOfLongestSubstring("pwwkew"),3);
            assertEquals(lengthOfLongestSubstring("dvdf"),3);
        } catch(AssertionError e){
            String message = e.getMessage();
            System.out.println(e);
        }
    }

    static int lengthOfLongestSubstring(String s){

        int max_length = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(map.get(s.charAt(i)), left);
            }
            max_length = Math.max(max_length, i-left+1);
            map.put(s.charAt(i),i+1);
        }

        return max_length;


    }
}
