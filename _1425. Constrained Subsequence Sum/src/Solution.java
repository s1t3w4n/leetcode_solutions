import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
 * <p>
 * A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * Explanation: The subsequence is [10, 2, 5, 20].
 * Example 2:
 * <p>
 * Input: nums = [-1,-2,-3], k = 1
 * Output: -1
 * Explanation: The subsequence must be non-empty, so we choose the largest number.
 * Example 3:
 * <p>
 * Input: nums = [10,-2,-10,-5,20], k = 2
 * Output: 23
 * Explanation: The subsequence is [10, -2, -5, 20].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 10^5
 * -104 <= nums[i] <= 10^4
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += !dq.isEmpty() ? nums[dq.peekFirst()] : 0;

            while (!dq.isEmpty() && (i - dq.peekFirst() >= k || nums[i] >= nums[dq.peekLast()])) {
                if (nums[i] >= nums[dq.peekLast()]) dq.pollLast();
                else dq.pollFirst();
            }

            if (nums[i] > 0) {
                dq.offerLast(i);
            }
        }
        return Arrays.stream(nums).max().orElse(-1);
    }
}