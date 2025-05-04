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
public class Solution {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution().numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{5, 6}
        }));
        // 3
        System.out.println(new Solution().numEquivDominoPairs(new int[][]{
                new int[]{2, 1},
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 2}
        }));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0, l = dominoes.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (
                        (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                                ||
                                (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])
                ) {
                    count++;
                }
            }
        }
        return count;
    }
}