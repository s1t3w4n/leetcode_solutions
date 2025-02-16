import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of string words, return all strings in words that are a
 * substring
 * of another word. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 * <p>
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 * <p>
 * Input: words = ["blue","green","bu"]
 * Output: []
 * Explanation: No string of words is substring of another string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * All the strings of words are unique.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(new Solution().stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(new Solution().stringMatching(new String[]{"blue", "green", "bu"}));
    }

    public List<String> stringMatching(String[] words) {
        ArrayList<String> subs = new ArrayList<>(words.length);
        for (String word : words) {
            for (String sub : words) {
                if (word.length() >= sub.length()) {
                    continue;
                }
                if (sub.contains(word)) {
                    subs.add(word);
                    break;
                }
            }
        }
        return subs;
    }
}