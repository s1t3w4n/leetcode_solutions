import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
 * the smallest in lexicographical order
 * among all possible results.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution().removeDuplicateLetters("cdadabcc")); // "adbc"
        System.out.println(new Solution().removeDuplicateLetters("abcd")); // "abcd"
        System.out.println(new Solution().removeDuplicateLetters("ecbacba")); // "eacb"
    }

    public String removeDuplicateLetters(String s) {
        int[] frequency = new int[26];
        int[] visited = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']--;
            if (visited[s.charAt(i) - 'a'] == 0) {
                while (sb.length() != 0
                        && (sb.charAt(sb.length() - 1) > s.charAt(i))
                        && frequency[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = 0;
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(s.charAt(i));
                visited[s.charAt(i) - 'a'] = 1;
            }
        }
        return sb.toString();
    }
}