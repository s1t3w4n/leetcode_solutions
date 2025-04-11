/**
 * You are given two positive integers low and high.
 * <p>
 * An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
 * <p>
 * Return the number of symmetric integers in the range [low, high].
 * <p>
 * Example 1:
 * <p>
 * Input: low = 1, high = 100
 * Output: 9
 * Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
 * Example 2:
 * <p>
 * Input: low = 1200, high = 1230
 * Output: 4
 * Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 * <p>
 * Constraints:
 * <p>
 * 1 <= low <= high <= 10^4
 */
public class Solution {
    public static void main(String[] args) {
        // 9
        System.out.println(new Solution().countSymmetricIntegers(1, 100));
        // 4
        System.out.println(new Solution().countSymmetricIntegers(1200, 1230));
    }

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String v = String.valueOf(i);
            if (v.length() % 2 != 0) {
                continue;
            }
            int leftSum = 0;
            for (int j = 0; j < v.length() / 2; j++) {
                leftSum += Integer.parseInt(Character.toString(v.charAt(j)));
            }
            int rightSum = 0;
            for (int j = v.length() / 2; j < v.length(); j++) {
                rightSum += Integer.parseInt(Character.toString(v.charAt(j)));
            }
            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }
}