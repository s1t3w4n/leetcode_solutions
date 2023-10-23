/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * <p>
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 16
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
        System.out.println(new Solution().isPowerOfFour(5));
        System.out.println(new Solution().isPowerOfFour(1));
        System.out.println(new Solution().isPowerOfFour(8));
        System.out.println(new Solution().isPowerOfFour(-16));
    }

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}