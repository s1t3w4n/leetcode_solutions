import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer n.
 * <p>
 * Each number from 1 to n is grouped according to the sum of its digits.
 * <p>
 * Return the number of groups that have the largest size.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
 * There are 4 groups with largest size.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 */
public class Solution {
    public static void main(String[] args) {
        // 4
        System.out.println(new Solution().countLargestGroup(13));
        // 2
        System.out.println(new Solution().countLargestGroup(2));
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            sumToCount.merge(sum, 1, Integer::sum);
        }
        return sumToCount.values().stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .map(max -> (int) sumToCount.values().stream().filter(v -> v.equals(max)).count())
                .orElse(0);
    }
}