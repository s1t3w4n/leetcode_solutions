import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
        System.out.println(new Solution().reverseWords("God Ding"));
    }

    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> word.chars()
                        .mapToObj(i -> (char) i)
                        .collect(Collector.of(
                                StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::reverse))
                )
                .collect(Collectors.joining(" "));
    }
}