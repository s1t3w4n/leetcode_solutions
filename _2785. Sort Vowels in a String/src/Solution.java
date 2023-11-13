/**
 * Given a 0-indexed string s, permute s to get a new string t such that:
 * <p>
 * All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
 * The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
 * Return the resulting string.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lEetcOde"
 * Output: "lEOtcede"
 * Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
 * Example 2:
 * <p>
 * Input: s = "lYmpH"
 * Output: "lYmpH"
 * Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists only of letters of the English alphabet in uppercase and lowercase.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sortVowels("lEetcOde"));
        System.out.println(new Solution().sortVowels("lYmpH"));
    }

    // Returns true if the character is a vowel.
    public String sortVowels(String s) {
        int[] count = new int[1000];

        // Store the frequencies for each character.
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                count[c - 'A']++;
            }
        }

        // Sorted string having all the vowels.
        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!isVowel(s.charAt(i))) {
                ans.append(s.charAt(i));
            } else {
                // Skip to the character which is having remaining count.
                while (count[sortedVowel.charAt(j) - 'A'] == 0) {
                    j++;
                }

                ans.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j) - 'A']--;
            }
        }
        return ans.toString();
    }

    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}