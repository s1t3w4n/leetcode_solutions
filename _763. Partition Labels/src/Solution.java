import java.util.*;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * <p>
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        // [9,7,8]
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
        // [10]
        System.out.println(new Solution().partitionLabels("eccbbbbdec"));
    }

    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedHashMap<Character, Integer[]> charToStartEnd = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (charToStartEnd.containsKey(c)) {
                charToStartEnd.get(c)[1] = i;
            } else {
                charToStartEnd.put(c, new Integer[]{i , i});
            }
        }
        int maxStart = charToStartEnd.get(s.charAt(0))[0];
        int maxEnd = charToStartEnd.get(s.charAt(0))[1];
        for (Map.Entry<Character, Integer[]> characterEntry : charToStartEnd.entrySet()) {
                if (maxEnd < characterEntry.getValue()[0]) {
                    result.add(characterEntry.getValue()[0] - maxStart);
                    maxStart = characterEntry.getValue()[0];
                    maxEnd = characterEntry.getValue()[1];
                } else if (maxEnd < characterEntry.getValue()[1]) {
                    maxEnd = characterEntry.getValue()[1];
                }
                if (characterEntry.getValue()[1] == s.length() - 1) {
                    result.add(s.length() - maxStart);
                }
        }
        return result;
    }
}