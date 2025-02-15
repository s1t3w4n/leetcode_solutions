/**
 * Given a positive integer n, return the punishment number of n.
 * <p>
 * The punishment number of n is defined as the sum of the squares of all integers i such that:
 * <p>
 * 1 <= i <= n
 * The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 182
 * Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
 * - 1 since 1 * 1 = 1
 * - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
 * - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
 * Hence, the punishment number of 10 is 1 + 81 + 100 = 182
 * Example 2:
 * <p>
 * Input: n = 37
 * Output: 1478
 * Explanation: There are exactly 4 integers i in the range [1, 37] that satisfy the conditions in the statement:
 * - 1 since 1 * 1 = 1.
 * - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 + 1.
 * - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 + 0.
 * - 36 since 36 * 36 = 1296 and 1296 can be partitioned into 1 + 29 + 6.
 * Hence, the punishment number of 37 is 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class Solution {
    public static void main(String[] args) {
        // 0
        System.out.println(new Solution().punishmentNumber(0));
        // 1
        System.out.println(new Solution().punishmentNumber(1));
        // 182
        System.out.println(new Solution().punishmentNumber(10));
        // 1478
        System.out.println(new Solution().punishmentNumber(37));
    }

    public int punishmentNumber(int num) {
        int sum = 0;
        for (int n = 1; n <= num; n++) {
            int part = n * n;
            if (isPunishmentPart(String.valueOf(part), n)) {
                sum += part;
            }
        }
        return sum;
    }

    private boolean isPunishmentPart(String n, int goal) {
        if (goal < 0) {
            return false;
        }
        if (n.isEmpty() && goal == 0) {
            return true;
        }
        for (int i = 0; i < n.length(); i++) {
            int left = Integer.parseInt(n.substring(0, i + 1));
            String right = n.substring(i + 1);
            if (isPunishmentPart(right, goal - left)) {
                return true;
            }
        }
        return false;
    }
}