/**
 * You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
 * Given an integer k, return the kth letter (1-indexed) in the decoded string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leet2code3", k = 10
 * Output: "o"
 * Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 * <p>
 * Input: s = "ha22", k = 5
 * Output: "h"
 * Explanation: The decoded string is "hahahaha".
 * The 5th letter is "h".
 * Example 3:
 * <p>
 * Input: s = "a2345678999999999999999", k = 1
 * Output: "a"
 * Explanation: The decoded string is "a" repeated 8301530446056247680 times.
 * The 1st letter is "a".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= s.length <= 100
 * s consists of lowercase English letters and digits 2 through 9.
 * s starts with a letter.
 * 1 <= k <= 10^9
 * It is guaranteed that k is less than or equal to the length of the decoded string.
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("leet2code3", 10)); //o
        System.out.println(new Solution().decodeAtIndex("ha22", 5)); //h
        System.out.println(new Solution().decodeAtIndex("a2345678999999999999999", 1)); //a
    }

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (final char character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                size *= character - '0';
            } else {
                ++size;
            }
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            k %= size;
            if (k == 0 && Character.isAlphabetic(s.charAt(i))) {
                return s.substring(i, i + 1);
            }
            if (Character.isDigit(s.charAt(i))) {
                size /= s.charAt(i) - '0';
            } else {
                --size;
            }
        }
        throw new IllegalArgumentException();
    }
}