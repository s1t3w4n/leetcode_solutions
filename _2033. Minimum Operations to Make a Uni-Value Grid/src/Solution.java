import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
 * <p>
 * A uni-value grid is a grid where all the elements of it are equal.
 * <p>
 * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[2,4],[6,8]], x = 2
 * Output: 4
 * Explanation: We can make every element equal to 4 by doing the following:
 * - Add x to 2 once.
 * - Subtract x from 6 once.
 * - Subtract x from 8 twice.
 * A total of 4 operations were used.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,5],[2,3]], x = 1
 * Output: 5
 * Explanation: We can make every element equal to 3.
 * Example 3:
 * <p>
 * <p>
 * Input: grid = [[1,2],[3,4]], x = 2
 * Output: -1
 * Explanation: It is impossible to make every element equal.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= x, grid[i][j] <= 10^4
 */
public class Solution {
    public static void main(String[] args) {
        // 4
        System.out.println(new Solution().minOperations(new int[][]{
                new int[]{2, 4},
                new int[]{6, 8}
        }, 2));
        // 5
        System.out.println(new Solution().minOperations(new int[][]{
                new int[]{1, 5},
                new int[]{2, 3}
        }, 1));
        // -2
        System.out.println(new Solution().minOperations(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        }, 2));
    }

    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int[] m : grid) {
            for (int n : m) {
                sorted.add(n);
            }
        }
        Collections.sort(sorted);
        int median = sorted.get(sorted.size() / 2);
        int mReminder = median % x;
        int oCount = 0;
        for (Integer v : sorted) {
            if (v % x != mReminder) {
                return -1;
            }
            oCount += Math.abs(median - v) / x;
        }
        return oCount;
    }
}