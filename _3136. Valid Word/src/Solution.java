import java.util.Set;

/**
 * A word is considered valid if:
 * <p>
 * It contains a minimum of 3 characters.
 * It contains only digits (0-9), and English letters (uppercase and lowercase).
 * It includes at least one vowel.
 * It includes at least one consonant.
 * You are given a string word.
 * <p>
 * Return true if word is valid, otherwise, return false.
 * <p>
 * Notes:
 * <p>
 * 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
 * A consonant is an English letter that is not a vowel.
 * <p>
 * Example 1:
 * <p>
 * Input: word = "234Adas"
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * This word satisfies the conditions.
 * <p>
 * Example 2:
 * <p>
 * Input: word = "b3"
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * The length of this word is fewer than 3, and does not have a vowel.
 * <p>
 * Example 3:
 * <p>
 * Input: word = "a3$e"
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * This word contains a '$' character and does not have a consonant.
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 20
 * word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.
 */
public class Solution {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution().isValid("234Adas"));
        // false
        System.out.println(new Solution().isValid("b3"));
        // false
        System.out.println(new Solution().isValid("a3$e"));
        // false
        System.out.println(new Solution().isValid("UuE6"));
    }

    private static final Set<Character> wrongs = Set.of('@', '#', '$');
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        int cV = 0;
        int cC = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (wrongs.contains(c)) {
                return false;
            }
            if (c - '0' < 9) {
                continue;
            }
            if (vowels.contains(c)) {
                cV++;
            } else {
                cC++;
            }
        }
        return cC > 0 && cV > 0;
    }
}