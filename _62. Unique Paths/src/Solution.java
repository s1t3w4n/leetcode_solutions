/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution().uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int smaller = m > n ? n - 1 : m - 1;
        int totalsteps = m + n - 2;
        long result = 1;
        for (int counter = 1; counter <= smaller; counter++) {
            result *= totalsteps--;
            result /= counter;
        }
        return (int) result;
    }
}