package arrays;

import java.util.Arrays;
public class ProductExceptSelf {
    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
     *
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     * @param args
     */
    public static void main(String[] args){

    }

    /**
     * Solution with O(n) time complexity and O(n) Space complexity
     * 1.Calculate prefix and suffix array for each element
     * 2.retur the output array with each element as product of prefix and suffix value
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i] = prefix[i]*suffix[i];
        }
        return ans;
    }

    /**
     * Solution with constant space use the output array to store prefix and then modify
     * the same by multiplying with the suffix value
     * @param nums
     * @return
     */
    public int[] productExceptSelf_constantspace(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);

        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int right_product = 1;
        for(int i=nums.length-2;i>=0;i--){
            ans[i] = ans[i+1]*right_product;
            right_product = right_product*nums[i];
        }
        return ans;
    }

}
