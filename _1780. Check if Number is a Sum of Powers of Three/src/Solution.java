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
public class Solution {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution().checkPowersOfThree(12));
        // true
        System.out.println(new Solution().checkPowersOfThree(91));
        // false
        System.out.println(new Solution().checkPowersOfThree(21));
    }

    private static final int[] powers = new int[17];

    static {
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 3;
        }
    }

    public boolean checkPowersOfThree(int n) {
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] > n) {
                for (int j = i - 1; n > 0 && j >= 0; j--) {
                    if (n >= powers[j]) {
                        n -= powers[j];
                        if (n == 0) {
                            return true;
                        }
                    }
                }
                break;
            }
        }
        return false;
    }
}