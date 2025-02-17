import java.util.HashSet;
import java.util.Set;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 * <p>
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 * <p>
 * Example 1:
 * <p>
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 * <p>
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 * <p>
 * Input: tiles = "V"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        // 8
        System.out.println(new Solution().numTilePossibilities("AAB"));
        // 188
        System.out.println(new Solution().numTilePossibilities("AAABBC"));
        // 1
        System.out.println(new Solution().numTilePossibilities("V"));
    }

    public int numTilePossibilities(String tiles) {
        Set<String> possibilities = new HashSet<>();
        boolean[] usedIndexes = new boolean[tiles.length()];
        generatePossibilities("", usedIndexes, tiles, possibilities);
        return possibilities.size() - 1;
    }

    public void generatePossibilities(String current,
                                      boolean[] usedIndexes,
                                      String target,
                                      Set<String> possibilities) {
        possibilities.add(current);
        for (int i = 0; i < target.length(); i++) {
            if (!usedIndexes[i]) {
                usedIndexes[i] = true;
                generatePossibilities(current + target.charAt(i), usedIndexes, target, possibilities);
                usedIndexes[i] = false;
            }
        }
    }
}