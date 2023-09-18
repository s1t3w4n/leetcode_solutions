import java.util.Arrays;

/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <p>
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 * <p>
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kWeakestRows(new int[][]{
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 0},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1}
        }, 3)));
        System.out.println(Arrays.toString(new Solution().kWeakestRows(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{1, 1, 1, 1},
                new int[]{1, 0, 0, 0},
                new int[]{1, 0, 0, 0}
        }, 2)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] score = new int[rows];
        int j;
        for (int i = 0; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            score[i] = j * rows + i;
        }
        Arrays.sort(score);
        for (int i = 0; i < score.length; i++) {
            score[i] = score[i] % rows;
        }
        return Arrays.copyOfRange(score, 0, k);
    }
}