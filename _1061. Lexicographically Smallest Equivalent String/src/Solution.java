import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * <p>
 * We say s1[i] and s2[i] are equivalent characters.
 * <p>
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * <p>
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 * <p>
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical order.
 * So the answer is "makkek".
 * Example 2:
 * <p>
 * Input: s1 = "hello", s2 = "world", baseStr = "hold"
 * Output: "hdld"
 * Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
 * So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
 * Example 3:
 * <p>
 * Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * s1, s2, and baseStr consist of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        // "makkek"
        System.out.println(new Solution().smallestEquivalentString("parker", "morris", "parser"));
        // "hdld"
        System.out.println(new Solution().smallestEquivalentString("hello", "world", "hold"));
        // "aauaaaaada"
        System.out.println(new Solution().smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Set<Character>> relations = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            Set<Character> set1 = relations.getOrDefault(c1, new HashSet<>(Set.of(c1)));
            Set<Character> set2 = relations.getOrDefault(c2, new HashSet<>(Set.of(c2)));
            set1.add(c2);
            set2.add(c1);
            set1.addAll(set2);
            for (Character c : set1) {
                relations.put(c, set1);
            }
        }
        Map<Character, Character> map = relations.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().sorted().findFirst().orElse('a')));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            result.append(map.getOrDefault(baseStr.charAt(i), baseStr.charAt(i)));
        }
        return result.toString();
    }
}