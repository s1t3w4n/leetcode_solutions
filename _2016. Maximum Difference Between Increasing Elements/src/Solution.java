/**
 * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
 * <p>
 * Return the maximum difference. If no such i and j exists, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [7,1,5,4]
 * Output: 4
 * Explanation:
 * The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
 * Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.
 * Example 2:
 * <p>
 * Input: nums = [9,4,3,2]
 * Output: -1
 * Explanation:
 * There is no i and j such that i < j and nums[i] < nums[j].
 * Example 3:
 * <p>
 * Input: nums = [1,5,2,10]
 * Output: 9
 * Explanation:
 * The maximum difference occurs with i = 0 and j = 3, nums[j] - nums[i] = 10 - 1 = 9.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 2 <= n <= 1000
 * 1 <= nums[i] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        // 4
        System.out.println(new Solution().maximumDifference(new int[]{7,1,5,4}));
        // -1
        System.out.println(new Solution().maximumDifference(new int[]{9,4,3,2}));
        // 9
        System.out.println(new Solution().maximumDifference(new int[]{1,5,2,10}));
    }

    public int maximumDifference(int[] nums) {
        int min = 0;
        int dif = -1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[min]) {
                dif = Math.max(dif, nums[i] - nums[min]);
            } else {
                min = i;
            }
        }
        return dif;
    }
}