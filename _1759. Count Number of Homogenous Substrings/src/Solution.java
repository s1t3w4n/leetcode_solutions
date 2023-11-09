/**
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * A string is homogenous if all the characters of the string are the same.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 * Example 2:
 * <p>
 * Input: s = "xy"
 * Output: 2
 * Explanation: The homogenous substrings are "x" and "y".
 * Example 3:
 * <p>
 * Input: s = "zzzzz"
 * Output: 15
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists of lowercase letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countHomogenous("abbcccaa"));
        System.out.println(new Solution().countHomogenous("xy"));
        System.out.println(new Solution().countHomogenous("zzzzz"));
    }

    public int countHomogenous(String s) {
        int answer = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                currStreak++;
            } else {
                currStreak = 1;
            }

            answer = (answer + currStreak) % MOD;
        }

        return answer;
    }
}