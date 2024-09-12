/**
 * There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 * <p>
 * multiply the number on display by 2, or
 * subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: startValue = 2, target = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 * <p>
 * Input: startValue = 5, target = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 * <p>
 * Input: startValue = 3, target = 10
 * Output: 3
 * Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= startValue, target <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        final int i1 = new Solution().brokenCalc(2, 3);
        System.out.println(i1 + " : " + (i1 == 2));
        final int i2 = new Solution().brokenCalc(5, 8);
        System.out.println(i2 + " : " + (i2 == 2));
        final int i3 = new Solution().brokenCalc(3, 10);
        System.out.println(i3 + " : " + (i3 == 3));
    }

    public int brokenCalc(int s, int t) {
        if (s >= t) {
            return s - t;
        }
        if (t % 2 == 0) {
            return brokenCalc(s, t / 2) + 1;
        }
        return brokenCalc(s, t + 1) + 1;
    }
}