import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 * <p>
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 * Example 3:
 * <p>
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s contains only lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDeletions("aab"));
        System.out.println(new Solution().minDeletions("aaabbbcc"));
        System.out.println(new Solution().minDeletions("ceabaacb"));
        System.out.println(new Solution().minDeletions("accdcdadddbaadbc"));
    }

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) freq[ch-'a']++;
        Arrays.sort(freq);
        int res = 0;
        for(int i=24;i>=0;i--){
            if(freq[i] == 0) break;
            if(freq[i] >= freq[i+1]){
                int count = freq[i] - freq[i+1] + 1;
                freq[i] -= count;
                res += count;
                if(freq[i] < 0) res += freq[i];
            }
        }
        return res;
    }
}