/**
 * You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
 * <p>
 * For each queries[i]:
 * <p>
 * Select a subset of indices within the range [li, ri] in nums.
 * Decrement the values at the selected indices by 1.
 * A Zero Array is an array where all elements are equal to 0.
 * <p>
 * Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,1], queries = [[0,2]]
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * For i = 0:
 * Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
 * The array will become [0, 0, 0], which is a Zero Array.
 * Example 2:
 * <p>
 * Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * For i = 0:
 * Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
 * The array will become [4, 2, 1, 0].
 * For i = 1:
 * Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
 * The array will become [3, 1, 0, 0], which is not a Zero Array.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 */
public class Solution2 {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution2().isZeroArray(
                new int[]{1, 0, 1},
                new int[][]{
                        new int[]{0, 2}
                }));
        // false
        System.out.println(new Solution2().isZeroArray(
                new int[]{4, 3, 2, 1},
                new int[][]{
                        new int[]{1, 3},
                        new int[]{0, 2}
                }));
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int[] q : queries) {
            dp[q[0]] += 1;
            dp[q[1] + 1] -= 1;
        }
        int[] counts = new int[dp.length];
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current += dp[i];
            counts[i] = current;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > counts[i]) {
                return false;
            }
        }
        return true;
    }
}