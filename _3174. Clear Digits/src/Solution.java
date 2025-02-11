/**
 * You are given a string s.
 * <p>
 * Your task is to remove all digits by doing this operation repeatedly:
 * <p>
 * Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc"
 * <p>
 * Output: "abc"
 * <p>
 * Explanation:
 * <p>
 * There is no digit in the string.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cb34"
 * <p>
 * Output: ""
 * <p>
 * Explanation:
 * <p>
 * First, we apply the operation on s[2], and s becomes "c4".
 * <p>
 * Then we apply the operation on s[1], and s becomes "".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists only of lowercase English letters and digits.
 * The input is generated such that it is possible to delete all digits.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }

    public static String clearDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int digitCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                digitCount++;
            } else if (digitCount > 0) {
                digitCount--;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.reverse().toString();
    }
}