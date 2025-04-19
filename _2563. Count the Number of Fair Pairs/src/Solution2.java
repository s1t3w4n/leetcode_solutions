import java.util.Arrays;

/**
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 * <p>
 * A pair (i, j) is fair if:
 * <p>
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * Output: 6
 * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 * Example 2:
 * <p>
 * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
 * Output: 1
 * Explanation: There is a single fair pair: (2,3).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * nums.length == n
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= lower <= upper <= 10^9
 */
public class Solution2 {
    public static void main(String[] args) {
        // 6
        System.out.println(new Solution2().countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        // 1
        System.out.println(new Solution2().countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }
}