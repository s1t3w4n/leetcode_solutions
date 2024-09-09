/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class Solution {

    public static void main(String[] args) {
        final int i1 = new Solution().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(i1 + " : " + (i1 == 4));
        final int i2 = new Solution().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}});
        System.out.println(i2 + " : " + (i2 == -1));
        final int i3 = new Solution().orangesRotting(new int[][]{{0, 2}});
        System.out.println(i3 + " : " + (i3 == 0));
    }

    public int orangesRotting(int[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 2) {
                    rot(grid, y, x, 2);
                }
            }
        }

        int minutes = 2;

        for (int[] line : grid) {
            for (int cell : line) {
                if (cell == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void rot(int[][] grid, int y, int x, int minutes) {
        if (y >= 0 && y < grid.length
                && x >= 0 && x < grid[y].length
                && grid[y][x] != 0
                && (grid[y][x] <= 1 || grid[y][x] >= minutes)) {
            grid[y][x] = minutes;
            rot(grid, y, x + 1, minutes + 1);
            rot(grid, y, x - 1, minutes + 1);
            rot(grid, y + 1, x, minutes + 1);
            rot(grid, y - 1, x, minutes + 1);
        }
    }
}