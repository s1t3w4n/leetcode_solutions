/**
 * Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,4,1]
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,1,1]
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * [1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Solution {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution().countSubarrays(new int[]{1,2,1,4,1}));
        // 0
        System.out.println(new Solution().countSubarrays(new int[]{1,1,1}));
    }

    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if((nums[i] + nums[i+2])*2 == nums[i+1]) {
                count++;
            }
        }
        return count;
    }
}