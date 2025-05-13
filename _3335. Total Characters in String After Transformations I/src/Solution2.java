/**
 * You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:
 * <p>
 * If the character is 'z', replace it with the string "ab".
 * Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
 * Return the length of the resulting string after exactly t transformations.
 * <p>
 * Since the answer may be very large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcyy", t = 2
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * <p>
 * First Transformation (t = 1):
 * 'a' becomes 'b'
 * 'b' becomes 'c'
 * 'c' becomes 'd'
 * 'y' becomes 'z'
 * 'y' becomes 'z'
 * String after the first transformation: "bcdzz"
 * Second Transformation (t = 2):
 * 'b' becomes 'c'
 * 'c' becomes 'd'
 * 'd' becomes 'e'
 * 'z' becomes "ab"
 * 'z' becomes "ab"
 * String after the second transformation: "cdeabab"
 * Final Length of the string: The string is "cdeabab", which has 7 characters.
 * Example 2:
 * <p>
 * Input: s = "azbk", t = 1
 * <p>
 * Output: 5
 * <p>
 * Explanation:
 * <p>
 * First Transformation (t = 1):
 * 'a' becomes 'b'
 * 'z' becomes "ab"
 * 'b' becomes 'c'
 * 'k' becomes 'l'
 * String after the first transformation: "babcl"
 * Final Length of the string: The string is "babcl", which has 5 characters.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 * 1 <= t <= 10^5
 */
public class Solution2 {
    public static void main(String[] args) {
        // 7
        System.out.println(new Solution2().lengthAfterTransformations("abcyy", 2));
        // 5
        System.out.println(new Solution2().lengthAfterTransformations("azbk", 1));
        // 1
        System.out.println(new Solution2().lengthAfterTransformations("e", 6));
        // 79033769
        System.out.println(new Solution2().lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
        // 500060987
        System.out.println(new Solution2().lengthAfterTransformations("bheanuyzjlwflksvyzuku", 9433));

    }

    private static final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int z = freq[25];
            for (int j = 25; j > 0; j--) {
                freq[j] = freq[j - 1];
            }
            freq[0] = z;
            freq[1] = (freq[1] + z) % MOD;
        }
        int res = 0;
        for (Integer i : freq) {
            res = (res + i) % MOD;
        }
        return res;
    }
}