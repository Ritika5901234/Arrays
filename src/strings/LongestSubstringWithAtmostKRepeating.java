package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * Medium
 *
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class LongestSubstringWithAtmostKRepeating {

    public static void main(String[] args){

        try{
            assertEquals(longestSubstringWithAtmostKRepeating("eceba"), 3);
            assertEquals(longestSubstringWithAtmostKRepeating("ccaabbb"),5);
            assertEquals(longestSubstringWithAtmostKRepeating("pwwkew"),3);
        } catch(AssertionError e){
            String message = e.getMessage();
            System.out.println(e);
        }
    }



    static int longestSubstringWithAtmostKRepeating(String s){
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        int n = s.length();
        if(n < 3)
            return n;

        int left  = 0;
        int right = 0;
        int max_length = 2;

        while(right < n){
            if(map.size() < 3){
                map.put(s.charAt(right), right++);
            }

            if(map.size() == 3){
                int left_index =  Collections.min(map.values());
                map.remove(s.charAt(left_index));
                left = left_index+1;
            }

            max_length = Math.max(max_length, right - left);
        }
        return max_length;
    }

}
