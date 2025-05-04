/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
 * <p>
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 * <p>
 * Example 1:
 * <p>
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= dominoes.length <= 4 * 104
 * dominoes[i].length == 2
 * 1 <= dominoes[i][j] <= 9
 */
public class Solution3 {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution3().numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{5, 6}
        }));
        // 3
        System.out.println(new Solution3().numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 2}
        }));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] dp = new int[10][10];
        for (int[] domino : dominoes) {
            dp[domino[0]][domino[1]]++;
        }
        int resCount = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {
                int count = dp[i][j];
                if (i != j) {
                    count += dp[j][i];
                }
                resCount += count * (count - 1) / 2;
            }
        }
        return resCount;
    }
}