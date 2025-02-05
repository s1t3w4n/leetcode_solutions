/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * <p>
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 * <p>
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 * <p>
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        boolean eq = true;
        boolean swapped = false;
        int swapIndex = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (swapped) {
                    return false;
                }
                if (eq) {
                    swapIndex = i;
                    eq = false;
                } else if (s1.charAt(swapIndex) == s2.charAt(i) && s1.charAt(i) == s2.charAt(swapIndex)) {
                    eq = true;
                    swapped = true;
                } else {
                    return false;
                }
            }
        }
        return eq;
    }
}