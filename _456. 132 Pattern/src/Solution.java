/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * <p>
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * <p>
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 2 * 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(new Solution().find132pattern(new int[]{-1, 3, 2, 0}));
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int previousMin = Integer.MIN_VALUE;
        int potentialPeak = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < previousMin) {
                return true;
            }
            while (potentialPeak < nums.length && nums[i] > nums[potentialPeak]) {
                previousMin = nums[potentialPeak++];
            }
            potentialPeak--;
            nums[potentialPeak] = nums[i];
        }
        return false;
    }
}