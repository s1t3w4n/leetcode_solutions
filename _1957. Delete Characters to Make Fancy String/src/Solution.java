/**
 * A fancy string is a string where no three consecutive characters are equal.
 * <p>
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 * <p>
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leeetcode"
 * Output: "leetcode"
 * Explanation:
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 * Example 2:
 * <p>
 * Input: s = "aaabaaaa"
 * Output: "aabaa"
 * Explanation:
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 * Example 3:
 * <p>
 * Input: s = "aab"
 * Output: "aab"
 * Explanation: No three consecutive characters are equal, so return "aab".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        // leetcode
        System.out.println(new Solution().makeFancyString("leeetcode"));
        // aabaa
        System.out.println(new Solution().makeFancyString("aaabaaaa"));
        // aab
        System.out.println(new Solution().makeFancyString("aab"));
    }

    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int count = 1;
        var sb = new StringBuilder();
        sb.append(prev);
        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(prev != curr) {
                count = 0;
                prev = curr;
            }
            count++;
            if (count > 2) {
                continue;
            }
            sb.append(curr);
        }
        return sb.toString();
    }
}