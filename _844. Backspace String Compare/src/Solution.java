/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * <p>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * <p>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * <p>
 * <p>
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("ab##", "c#d#"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String s, String t) {
        int i = nextChar(s, s.length() - 1);
        int j = nextChar(t, t.length() - 1);
        while (i > -1 && j > -1) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i = nextChar(s, i - 1);
            j = nextChar(t, j - 1);
        }
        return i == -1 && j == -1;
    }

    private static int nextChar(String str, int cur) {
        while (cur > -1 && str.charAt(cur) == '#') {
            int cnt = 1;
            for (cur--; cur > -1 && cnt > 0; cur--)
                cnt += str.charAt(cur) == '#' ? 1 : -1;
        }
        return cur;
    }
}