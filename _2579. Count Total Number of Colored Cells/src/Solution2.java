/**
 * There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:
 * <p>
 * At the first minute, color any arbitrary unit cell blue.
 * Every minute thereafter, color blue every uncolored cell that touches a blue cell.
 * Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
 * <p>
 * <p>
 * Return the number of colored cells at the end of n minutes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: 1
 * Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 5
 * Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public class Solution2 {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution2().coloredCells(1));
        // 5
        System.out.println(new Solution2().coloredCells(2));
        // 25
        System.out.println(new Solution2().coloredCells(4));
        // 9709071901
        System.out.println(new Solution2().coloredCells(69675));
    }

    public long coloredCells(int n) {
        long ans = 1L;
        long mul = 2L*(n-1)*n;
        return ans+mul;
    }
}