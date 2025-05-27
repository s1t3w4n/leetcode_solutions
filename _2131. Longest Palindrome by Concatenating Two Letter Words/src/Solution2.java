import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * <p>
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 * <p>
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 * <p>
 * A palindrome is a string that reads the same forward and backward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 * Example 2:
 * <p>
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 * Example 3:
 * <p>
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is "xx".
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 10^5
 * words[i].length == 2
 * words[i] consists of lowercase English letters.
 */
public class Solution2 {
    public static void main(String[] args) {
        // 6
        System.out.println(new Solution2().longestPalindrome(new String[]{"lc", "cl", "gg"}));
        // 8
        System.out.println(new Solution2().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        // 2
        System.out.println(new Solution2().longestPalindrome(new String[]{"cc", "ll", "xx"}));
    }

    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        }
        int count = 0;
        boolean singlePalindrome = false;
        for (Map.Entry<String, Integer> candidate : wordToFreq.entrySet()) {
            String word = candidate.getKey();
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                count += candidate.getValue() / 2 * 4;
                if (!singlePalindrome && candidate.getValue() % 2 == 1) {
                    singlePalindrome = true;
                }
            } else if(word.compareTo(reversed) > 0 && wordToFreq.containsKey(reversed)) {
                count += Math.min(candidate.getValue(), wordToFreq.get(reversed)) * 4;
            }
        }
        return count + (singlePalindrome ? 2 : 0);
    }
}