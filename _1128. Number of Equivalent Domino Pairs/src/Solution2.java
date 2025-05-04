import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class Solution2 {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution2().numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{5, 6}
        }));
        // 3
        System.out.println(new Solution2().numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 2}
        }));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        List<List<Integer>> counts = IntStream.range(0, 10)
                .mapToObj(i ->
                        IntStream.range(0, 10)
                                .mapToObj(j -> 0)
                                .collect(Collectors.toList()))
                .toList();
        for (int[] domino : dominoes) {
            int k = Math.max(domino[0], domino[1]);
            int v = Math.min(domino[0], domino[1]);
            counts.get(k).set(v, counts.get(k).get(v) + 1);
        }
        return counts.stream()
                .flatMap(Collection::stream)
                .filter(v -> v > 1)
                .map(v -> v * (v - 1) / 2)
                .reduce(0, Integer::sum);
    }
}