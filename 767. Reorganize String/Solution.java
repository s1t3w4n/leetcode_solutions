import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aab"));
        System.out.println(new Solution().reorganizeString("aaab"));
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> que = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        que.addAll(map.keySet());
        if (map.get(que.peek()) > (s.length() + 1) / 2) {
            return "";
        }
        char[] result = new char[s.length()];
        int i = 0;
        while (!que.isEmpty()) {
            char c = que.poll();
            for (int j = 0; j < map.get(c); j++) {
                if (i >= s.length()) i = 1;
                result[i] = c;
                i += 2;
            }
        }
        return new String(result);
    }
}