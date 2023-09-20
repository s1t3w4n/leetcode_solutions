/**
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 * <p>
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 1 <= x <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(new Solution().minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(new Solution().minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public int minOperations(int[] nums, int x) {
        int result = -1;
        int summary = 0;
        for (int num : nums) {
            summary += num;
        }
        if (summary == x) {
            return nums.length;
        }
        int operation = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            operation += nums[i];
            while (count < i && summary - operation < x) {
                operation -= nums[count++];
            }
            if (summary - operation == x) {
                result = Math.max(result, i - count + 1);
            }
        }
        if (result == -1) {
            return result;
        }
        return nums.length - result;
    }
}