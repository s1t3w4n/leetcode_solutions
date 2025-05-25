import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
public class Solution {
    public static void main(String[] args) {
        // 6
        System.out.println(new Solution().longestPalindrome(new String[]{"lc", "cl", "gg"}));
        // 8
        System.out.println(new Solution().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        // 2
        System.out.println(new Solution().longestPalindrome(new String[]{"cc", "ll", "xx"}));
    }

    public int longestPalindrome(String[] words) {
        int count = 0;
        Map<String, Integer> candidates = new HashMap<>();
        Map<String, Integer> pCandidates = new HashMap<>();
        for (String w : words) {
            if (w.charAt(0) == w.charAt(1)) {
                if (pCandidates.containsKey(w)) {
                    if (pCandidates.get(w) > 0) {
                        pCandidates.put(w, pCandidates.get(w) - 1);
                        count += 4;
                    } else {
                        pCandidates.put(w, pCandidates.get(w) + 1);
                    }
                } else {
                    pCandidates.put(w, 1);
                }
            } else {
                String candidate = w.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
                if (candidate.equals(w)) {
                    if (candidates.containsKey(candidate)) {
                        if (candidates.get(candidate) < 0 ) {
                            count += 4;
                        }
                        candidates.put(candidate, candidates.get(candidate) + 1);
                    } else {
                        candidates.put(candidate, 1);
                    }
                } else {
                    if (candidates.containsKey(candidate)) {
                        if (candidates.get(candidate) > 0 ) {
                            count += 4;
                        }
                        candidates.put(candidate, candidates.get(candidate) - 1);
                    } else {
                        candidates.put(candidate, -1);
                    }
                }
            }
        }
        if (pCandidates.entrySet().stream().anyMatch(e -> e.getValue() == 1)) {
            count += 2;
        }
        return count;
    }
}