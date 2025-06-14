/**
 * You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.
 * <p>
 * Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.
 * <p>
 * Notes:
 * <p>
 * When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
 * Bob can remap a digit to itself, in which case num does not change.
 * Bob can remap different digits for obtaining minimum and maximum values respectively.
 * The resulting number after remapping can contain leading zeroes.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 11891
 * Output: 99009
 * Explanation:
 * To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
 * To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
 * The difference between these two numbers is 99009.
 * Example 2:
 * <p>
 * Input: num = 90
 * Output: 99
 * Explanation:
 * The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can be returned by the function is 0 (if 9 is replaced by 0).
 * Thus, we return 99.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 10^8
 */
public class Solution {
    public static void main(String[] args) {
        // 99009
        System.out.println(new Solution().minMaxDifference(11891));
        // 99
        System.out.println(new Solution().minMaxDifference(90));
    }

    public int minMaxDifference(int num) {
        var sNum = String.valueOf(num);
        var minBuilder = new StringBuilder();
        var maxBuilder = new StringBuilder();
        var minSwap = sNum.charAt(0);
        var maxSwap = sNum.charAt(0);
        for(int i = 0; i < sNum.length(); i++) {
            if(maxSwap == '9' && sNum.charAt(i) != '9') {
                maxSwap = sNum.charAt(i);
            }
            if (sNum.charAt(i) == minSwap) {
                minBuilder.append('0');
            } else {
                minBuilder.append(sNum.charAt(i));
            }
            if (sNum.charAt(i) == maxSwap) {
                maxBuilder.append('9');
            } else {
                maxBuilder.append(sNum.charAt(i));
            }
        }
        var max = Integer.valueOf(maxBuilder.toString());
        var min = Integer.valueOf(minBuilder.toString());
        return max - min;
    }
}