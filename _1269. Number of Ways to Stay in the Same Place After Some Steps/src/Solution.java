import java.util.Arrays;

/**
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).
 * <p>
 * Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 * <p>
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 * <p>
 * Input: steps = 4, arrLen = 2
 * Output: 8
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
        System.out.println(new Solution().numWays(2, 4));
        System.out.println(new Solution().numWays(4, 2));
    }

    int[][] memo;
    int MOD = (int) 1e9 + 7;
    int arrLen;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        this.arrLen = arrLen;
        memo = new int[arrLen][steps + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, steps);
    }

    public int dp(int curr, int remain) {
        if (remain == 0) {
            if (curr == 0) {
                return 1;
            }

            return 0;
        }

        if (memo[curr][remain] != -1) {
            return memo[curr][remain];
        }

        int ans = dp(curr, remain - 1);
        if (curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % MOD;
        }

        if (curr < arrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = ans;
        return ans;
    }
}