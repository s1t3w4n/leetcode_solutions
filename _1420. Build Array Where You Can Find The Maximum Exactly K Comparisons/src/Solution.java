/**
 * You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:
 * <p>
 * You should build the array arr which has the following properties:
 * <p>
 * arr has exactly n integers.
 * 1 <= arr[i] <= m where (0 <= i < n).
 * After applying the mentioned algorithm to arr, the value search_cost is equal to k.
 * Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2, m = 3, k = 1
 * Output: 6
 * Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 * Example 2:
 * <p>
 * Input: n = 5, m = 2, k = 3
 * Output: 0
 * Explanation: There are no possible arrays that satisify the mentioned conditions.
 * Example 3:
 * <p>
 * Input: n = 9, m = 1, k = 1
 * Output: 1
 * Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfArrays(2, 3, 1));
        System.out.println(new Solution().numOfArrays(5, 2, 3));
        System.out.println(new Solution().numOfArrays(9, 1, 1));
    }

    public int numOfArrays(int n, int m, int k) {
        long[][] dp = new long[m + 1][k + 1];
        long[][] prefix = new long[m + 1][k + 1];
        long[][] prevDp = new long[m + 1][k + 1];
        long[][] prevPrefix = new long[m + 1][k + 1];
        int MOD = (int) 1e9 + 7;

        for (int num = 1; num <= m; num++) {
            dp[num][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                dp = new long[m + 1][k + 1];
            }

            prefix = new long[m + 1][k + 1];

            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    long ans = (maxNum * prevDp[maxNum][cost]) % MOD;
                    ans = (ans + prevPrefix[maxNum - 1][cost - 1]) % MOD;

                    dp[maxNum][cost] += ans;
                    dp[maxNum][cost] %= MOD;

                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]);
                    prefix[maxNum][cost] %= MOD;
                }
            }

            prevDp = dp;
            prevPrefix = prefix;
        }

        return (int) prefix[m][k];
    }
}