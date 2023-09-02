import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
 * <p>
 * Return the minimum number of extra characters left over if you break up s optimally.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
 * Output: 1
 * Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "sayhelloworld", dictionary = ["hello","world"]
 * Output: 3
 * Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] and s consists of only lowercase English letters
 * dictionary contains distinct words
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
        System.out.println(new Solution().minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictionarySet = new HashSet<>();
        Collections.addAll(dictionarySet, dictionary);
        int length = s.length();
        int[] words = new int[length + 1];
        words[0] = 0;
        for (int i = 1; i <= length; ++i) {
            words[i] = words[i - 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (dictionarySet.contains(s.substring(j, i))) {
                    words[i] = Math.min(words[i], words[j]);
                }
            }
        }
        return words[length];
    }
}