import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:
 * <p>
 * (startx, starty): The bottom-left corner of the rectangle.
 * (endx, endy): The top-right corner of the rectangle.
 * Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
 * <p>
 * Each of the three resulting sections formed by the cuts contains at least one rectangle.
 * Every rectangle belongs to exactly one section.
 * Return true if such cuts can be made; otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * We can make vertical cuts at x = 2 and x = 3. Hence, output is true.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence, output is false.
 * <p>
 * Constraints:
 * <p>
 * 3 <= n <= 109
 * 3 <= rectangles.length <= 105
 * 0 <= rectangles[i][0] < rectangles[i][2] <= n
 * 0 <= rectangles[i][1] < rectangles[i][3] <= n
 * No two rectangles overlap.
 */
public class Solution {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution().checkValidCuts(6, new int[][]{
                new int[]{1, 0, 5, 2},
                new int[]{0, 2, 2, 4},
                new int[]{3, 2, 5, 3},
                new int[]{0, 4, 4, 5}
        }));
        // true
        System.out.println(new Solution().checkValidCuts(4, new int[][]{
                new int[]{0, 0, 1, 1},
                new int[]{2, 0, 3, 4},
                new int[]{0, 2, 2, 3},
                new int[]{3, 0, 4, 3}
        }));
        // false
        System.out.println(new Solution().checkValidCuts(4, new int[][]{
                new int[]{0, 2, 2, 4},
                new int[]{1, 0, 3, 2},
                new int[]{2, 2, 3, 4},
                new int[]{3, 0, 4, 2},
                new int[]{3, 2, 4, 4}
        }));
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        // Try both horizontal and vertical cuts
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    // Check if valid cuts can be made in a specific dimension
    private boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;

        // Sort rectangles by their starting coordinate in the given dimension
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[dim]));

        // Track the furthest ending coordinate seen so far
        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            // If current rectangle starts after the furthest end we've seen,
            // we found a gap where a cut can be made
            if (furthestEnd <= rect[dim]) {
                gapCount++;
                if (gapCount == 2) {
                    return true;
                }
            }

            // Update the furthest ending coordinate
            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        // We need at least 2 gaps to create 3 sections
        return false;
    }
}