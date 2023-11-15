import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 * <p>
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 * <p>
 * A palindrome is a string that reads the same forwards and backwards.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabca"
 * Output: 3
 * Explanation: The 3 palindromic subsequences of length 3 are:
 * - "aba" (subsequence of "aabca")
 * - "aaa" (subsequence of "aabca")
 * - "aca" (subsequence of "aabca")
 * Example 2:
 * <p>
 * Input: s = "adc"
 * Output: 0
 * Explanation: There are no palindromic subsequences of length 3 in "adc".
 * Example 3:
 * <p>
 * Input: s = "bbcbaba"
 * Output: 4
 * Explanation: The 4 palindromic subsequences of length 3 are:
 * - "bbb" (subsequence of "bbcbaba")
 * - "bcb" (subsequence of "bbcbaba")
 * - "bab" (subsequence of "bbcbaba")
 * - "aba" (subsequence of "bbcbaba")
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromicSubsequence("aabca"));
        System.out.println(new Solution().countPalindromicSubsequence("adc"));
        System.out.println(new Solution().countPalindromicSubsequence("bbcbaba"));
    }

    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }

            last[curr] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            Set<Character> between = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}