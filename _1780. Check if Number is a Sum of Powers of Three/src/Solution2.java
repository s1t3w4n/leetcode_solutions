/**
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 * <p>
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 31 + 32
 * Example 2:
 * <p>
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 30 + 32 + 34
 * Example 3:
 * <p>
 * Input: n = 21
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^7
 */
public class Solution2 {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution2().checkPowersOfThree(12));
        // true
        System.out.println(new Solution2().checkPowersOfThree(91));
        // false
        System.out.println(new Solution2().checkPowersOfThree(21));
    }

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}