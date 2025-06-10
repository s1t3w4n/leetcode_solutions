/**
 * You are given a string s consisting of lowercase English letters.
 * <p>
 * Your task is to find the maximum difference diff = a1 - a2 between the frequency of characters a1 and a2 in the string such that:
 * <p>
 * a1 has an odd frequency in the string.
 * a2 has an even frequency in the string.
 * Return this maximum difference.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaaaabbc"
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
 * The maximum difference is 5 - 2 = 3.
 * Example 2:
 * <p>
 * Input: s = "abcabcab"
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
 * The maximum difference is 3 - 2 = 1.
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 100
 * s consists only of lowercase English letters.
 * s contains at least one character with an odd frequency and one with an even frequency.
 */
public class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().maxDifference("aaaaabbc"));
        // 1
        System.out.println(new Solution().maxDifference("abcabcab"));
        // -1
        System.out.println(new Solution().maxDifference("mmsmsym"));
    }

    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxO = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                maxO = Math.max(maxO, f);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int f : freq) {
            if (f == 0) continue;
            if (f % 2 == 0) {
                res = Math.max(res, maxO - f);
            }
        }
        return res;
    }
}