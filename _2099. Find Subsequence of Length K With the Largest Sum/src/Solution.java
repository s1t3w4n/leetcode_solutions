import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.
 * <p>
 * Return any such subsequence as an integer array of length k.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,1,3,3], k = 2
 * Output: [3,3]
 * Explanation:
 * The subsequence has the largest sum of 3 + 3 = 6.
 * Example 2:
 * <p>
 * Input: nums = [-1,-2,3,4], k = 3
 * Output: [-1,3,4]
 * Explanation:
 * The subsequence has the largest sum of -1 + 3 + 4 = 6.
 * Example 3:
 * <p>
 * Input: nums = [3,4,3,3], k = 2
 * Output: [3,4]
 * Explanation:
 * The subsequence has the largest sum of 3 + 4 = 7.
 * Another possible subsequence is [4, 3].
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Solution {
    public static void main(String[] args) {
        // [3,3]
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{2, 1, 3, 3}, 2)));
        // [-1,3,4]
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{-1, -2, 3, 4}, 3)));
        // [3,4]
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{3, 4, 3, 3}, 2)));
        // [63,61,-17,-55,-59,-10,2,-60,-65]
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{63, -74, 61, -17, -55, -59, -10, 2, -60, -65}, 9)));
        // [33,48]
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{33, -27, -9, -83, 48}, 2)));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int maxSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> nums[i]));
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
            queue.offer(i);
        }
        for (int i = k; i < nums.length; i++) {
            int sum = maxSum;
            sum -= nums[queue.peek()];
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[k];
        List<Integer> ids = queue.stream().sorted().toList();
        for (int i = 0; i < k; i++) {
            res[i] = nums[ids.get(i)];
        }
        return res;
    }
}