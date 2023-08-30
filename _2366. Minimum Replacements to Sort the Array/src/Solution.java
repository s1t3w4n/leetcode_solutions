/**
 * You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.
 * <p>
 * For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
 * Return the minimum number of operations to make an array that is sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,9,3]
 * Output: 2
 * Explanation: Here are the steps to sort the array in non-decreasing order:
 * - From [3,9,3], replace the 9 with 3 and 6 so the array becomes [3,3,6,3]
 * - From [3,3,6,3], replace the 6 with 3 and 3 so the array becomes [3,3,3,3,3]
 * There are 2 steps to sort the array in non-decreasing order. Therefore, we return 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: 0
 * Explanation: The array is already in non-decreasing order. Therefore, we return 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumReplacement(new int[]{3, 9, 3}));
        System.out.println(new Solution().minimumReplacement(new int[]{1, 2, 3, 4, 5}));
    }

    public long minimumReplacement(int[] nums) {
        int size = nums.length;
        int last = nums[size - 1];
        long replacement = 0;
        for (int i = size - 2; i >= 0; --i) {
            if (nums[i] > last) {
                int t = nums[i] / last;
                if (nums[i] % last != 0) {
                    t++;
                }
                last = nums[i] / t;
                replacement += t - 1;
            } else {
                last = nums[i];
            }
        }
        return replacement;
    }
}