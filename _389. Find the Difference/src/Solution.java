import java.util.HashMap;

/**
 * You are given two strings s and t.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Return the letter that was added to t.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", t = "abcde"
 * Output: "e"
 * Explanation: 'e' is the letter that was added.
 * Example 2:
 * <p>
 * Input: s = "", t = "y"
 * Output: "y"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s and t consist of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution().findTheDifference("", "y"));
    }

    public char findTheDifference(String s, String t) {
        final HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.keySet().stream().findFirst().orElse(' ');
    }
}