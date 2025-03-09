/**
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
 * <p>
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
 * <p>
 * Return the number of alternating groups.
 * <p>
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 * <p>
 * Example 1:
 * <p>
 * Input: colors = [0,1,0,1,0], k = 3
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * Alternating groups:
 * <p>
 * Example 2:
 * <p>
 * Input: colors = [0,1,0,0,1,0,1], k = 6
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * Alternating groups:
 * <p>
 * Example 3:
 * <p>
 * Input: colors = [1,1,0,1], k = 4
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Constraints:
 * <p>
 * 3 <= colors.length <= 10^5
 * 0 <= colors[i] <= 1
 * 3 <= k <= colors.length
 */
public class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{0,1,0,1,0}, 3));
        // 2
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6));
        // 0
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{1,1,0,1}, 4));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        boolean isCircle = true;
        int expected = colors[0] == 0 ? 1 : 0;;
        int dCount = 1;
        for (int i = 1; isCircle || i < k - 1; i++) {
            if (i == colors.length) {
                i = 0;
                isCircle = false;
            }
            if (expected == colors[i]) {
                expected = colors[i] == 0 ? 1 : 0;
                dCount++;
            } else {
                expected = colors[i] == 0 ? 1 : 0;
                dCount = 1;
            }
            if (dCount >= k) {
                count++;
            }
        }
        return count;
    }
}