/**
 * You are given four integers sx, sy, fx, fy, and a non-negative integer t.
 * <p>
 * In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.
 * <p>
 * Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
 * <p>
 * A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit the same cell several times.
 * <p>
 * Example 1:
 * <p>
 * Input: sx = 2, sy = 4, fx = 7, fy = 7, t = 6
 * Output: true
 * Explanation: Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds by going through the cells depicted in the picture above.
 * Example 2:
 * <p>
 * Input: sx = 3, sy = 1, fx = 7, fy = 3, t = 3
 * Output: false
 * Explanation: Starting at cell (3, 1), it takes at least 4 seconds to reach cell (7, 3) by going through the cells depicted in the picture above. Hence, we cannot reach cell (7, 3) at the third second.
 * <p>
 * Constraints:
 * <p>
 * 1 <= sx, sy, fx, fy <= 10^9
 * 0 <= t <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(new Solution().isReachableAtTime(3, 1, 7, 3, 3));
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);
        if (width == 0 && height == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(width, height);
    }
}