/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,0,1]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * <p>
 * Output: 8
 * <p>
 * Explanation:
 * <p>
 * n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class Solution {
    public static void main(String[] args) {
        // 2
        System.out.println(new Solution().missingNumber(new int[]{3,0,1}));
        // 2
        System.out.println(new Solution().missingNumber(new int[]{0,1}));
        // 8
        System.out.println(new Solution().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += i + 1 - nums[i];
        }
        return result;
    }
}