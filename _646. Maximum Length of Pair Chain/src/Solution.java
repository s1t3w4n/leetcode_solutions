import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * <p>
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * <p>
 * Return the length longest chain which can be formed.
 * <p>
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 1
 * Explanation: The longest chain is [1,2] -> [3,4].
 * Example 2:
 * <p>
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti <= 1000
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(new Solution().findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
    }

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int[][] dp = new int[len][2002];
        return solve(pairs, 0, len, -1001, dp);
    }

    private int solve(int[][] pairs, int index, int len, int prev, int[][] dp) {
        if (index >= len)
            return 0;
        if (dp[index][prev + 1001] != 0)
            return dp[index][prev + 1001];
        int include = 0;
        if (pairs[index][0] > prev)
            include = 1 + solve(pairs, index + 1, len, pairs[index][1], dp);
        int exclude = solve(pairs, index + 1, len, prev, dp);
        return dp[index][prev + 1001] = Math.max(include, exclude);
    }
}