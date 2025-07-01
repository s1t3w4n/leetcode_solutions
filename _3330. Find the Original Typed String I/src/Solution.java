/**
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
 * <p>
 * Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.
 * <p>
 * You are given a string word, which represents the final output displayed on Alice's screen.
 * <p>
 * Return the total number of possible original strings that Alice might have intended to type.
 * <p>
 * Example 1:
 * <p>
 * Input: word = "abbcccc"
 * <p>
 * Output: 5
 * <p>
 * Explanation:
 * <p>
 * The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
 * <p>
 * Example 2:
 * <p>
 * Input: word = "abcd"
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The only possible string is "abcd".
 * <p>
 * Example 3:
 * <p>
 * Input: word = "aaaa"
 * <p>
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 100
 * word consists only of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        // 5
        System.out.println(new Solution().possibleStringCount("abbcccc"));
        // 1
        System.out.println(new Solution().possibleStringCount("abcd"));
        // 4
        System.out.println(new Solution().possibleStringCount("aaaa"));
    }

    public int possibleStringCount(String word) {
        int count = 1;
        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                prev = curr;
            }
        }
        return count;
    }
}