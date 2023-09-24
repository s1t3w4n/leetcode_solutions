import java.util.ArrayList;
import java.util.List;

/**
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
 * <p>
 * Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
 * <p>
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 * <p>
 * <p>
 * <p>
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
 * Example 2:
 * <p>
 * Input: poured = 2, query_row = 1, query_glass = 1
 * Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
 * Example 3:
 * <p>
 * Input: poured = 100000009, query_row = 33, query_glass = 17
 * Output: 1.00000
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= poured <= 10^9
 * 0 <= query_glass <= query_row < 100
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().champagneTower(1, 1, 1));
        System.out.println(new Solution().champagneTower(2, 1, 1));
        System.out.println(new Solution().champagneTower(100000009, 33, 17));
    }

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] current = new double[queryRow + 1][queryGlass + 2];
        current[0][0] = poured;
        for (int i = 0; i < queryRow; i++)
            for (int j = 0; j <= queryGlass; j++)
                if (current[i][j] > 1) {
                    double drop = (current[i][j] - 1) / 2;
                    current[i + 1][j] += drop;
                    current[i + 1][j + 1] += drop;
                }
        return current[queryRow][queryGlass] < 1 ? current[queryRow][queryGlass] : 1;
    }
}