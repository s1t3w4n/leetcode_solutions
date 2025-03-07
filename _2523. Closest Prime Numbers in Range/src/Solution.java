import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given two positive integers left and right, find the two integers num1 and num2 such that:
 * <p>
 * left <= num1 < num2 <= right .
 * Both num1 and num2 are prime numbers.
 * num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
 * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: left = 10, right = 19
 * Output: [11,13]
 * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 * The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
 * Since 11 is smaller than 17, we return the first pair.
 * Example 2:
 * <p>
 * Input: left = 4, right = 6
 * Output: [-1,-1]
 * Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= left <= right <= 10^6
 */
class Solution {
    public static void main(String[] args) {
        // [11,13]
        System.out.println(Arrays.toString(new Solution().closestPrimes(10, 19)));
        // [-1,-1]
        System.out.println(Arrays.toString(new Solution().closestPrimes(4, 6)));
        // [29,31]
        System.out.println(Arrays.toString(new Solution().closestPrimes(19, 31)));
        // [84179, 84181]
        System.out.println(Arrays.toString(new Solution().closestPrimes(84084, 407043)));
    }

    public int[] closestPrimes(int left, int right) {
        int[] result = new int[]{-1, -1};
        int dif = Integer.MAX_VALUE;
        LinkedList<Integer> pair = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                pair.add(i);
                if (pair.size() == 2) {
                    int nDif = pair.getLast() - pair.getFirst();
                    if (nDif < dif) {
                        dif = nDif;
                        result[0] = pair.getFirst();
                        result[1] = pair.getLast();
                    }
                    pair.removeFirst();
                }
            }
        }
        return result;
    }


    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}