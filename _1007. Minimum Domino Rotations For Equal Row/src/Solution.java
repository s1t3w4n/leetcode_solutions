import java.util.Arrays;

/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 * <p>
 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * Constraints:
 * <p>
 * 2 <= tops.length <= 2 * 10^4
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 */
public class Solution {
    public static void main(String[] args) {
        // 2
        System.out.println(new Solution().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        // -1
        System.out.println(new Solution().minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
        // 0
        System.out.println(new Solution().minDominoRotations(new int[]{1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1}));
    }


    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] counts = new int[7][3];
        // Плиточка к счётчикам
        // Счётчки в массиве по индексам
        // 0 - индекс - это общее число упоминаний
        // 1 - индекс - вверху
        // 2 - индекс - внизу
        for (int i = 0; i < 7; i++) {
            counts[0] = new int[]{0, 0, 0};
        }
        int l = tops.length;
        for (int i = 0; i < l; i++) {
            int t = tops[i];
            int b = bottoms[i];
            if (t == b) {
                counts[t][0]++;
            } else {
                counts[t][0]++;
                counts[t][1]++;
                counts[b][0]++;
                counts[b][2]++;
            }
        }
        return Arrays.stream(counts)
                .filter(c -> c[0] == l)
                .map(c -> Math.min(c[1],c[2]))
                .findFirst().orElse(-1);
    }
}