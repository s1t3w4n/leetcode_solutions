/**
 * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
 * <p>
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 * <p>
 * Note that abs(x) is defined as follows:
 * <p>
 * If x is a negative integer, then abs(x) = -x.
 * If x is a non-negative integer, then abs(x) = x.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,-3,2,3,-4]
 * Output: 5
 * Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
 * Example 2:
 * <p>
 * Input: nums = [2,-5,1,-4,3,-2]
 * Output: 8
 * Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class Solution2 {
    public static void main(String[] args) {
        // 5
        System.out.println(new Solution2().maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        // 8
        System.out.println(new Solution2().maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }

    public int maxAbsoluteSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int currMin = 0;
        int currMax = 0;

        for (int num : nums) {
            currMax += num;
            if (max < currMax) {
                max = currMax;
            }
            if (currMax < 0) {
                currMax = 0;
            }
            currMin += num;
            if (min > currMin) {
                min = currMin;
            }
            if (currMin > 0) {
                currMin = 0;
            }
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}