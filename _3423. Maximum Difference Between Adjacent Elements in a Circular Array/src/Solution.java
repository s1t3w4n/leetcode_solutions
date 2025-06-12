/**
 * Given a circular array nums, find the maximum absolute difference between adjacent elements.
 * <p>
 * Note: In a circular array, the first and last elements are adjacent.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-5,-10,-5]
 * <p>
 * Output: 5
 * <p>
 * Explanation:
 * <p>
 * The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().maxAdjacentDistance(new int[]{1, 2, 4}));
        // 5
        System.out.println(new Solution().maxAdjacentDistance(new int[]{-5, -10, -5}));
    }

    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int dif = Math.abs(nums[i] - nums[i + 1]);
            if (dif > max) {
                max = dif;
            }
            dif = Math.abs(nums[i + 1] - nums[i]);
            if (dif > max) {
                max = dif;
            }
        }
        int dif = Math.abs(nums[0] - nums[nums.length - 1]);
        if (dif > max) {
            max = dif;
        }
        dif = Math.abs(nums[nums.length - 1] - nums[0]);
        if (dif > max) {
            max = dif;
        }
        return max;
    }
}