import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Example 1:
 * <p>
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * <p>
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * <p>
 * Input: rowIndex = 1
 * Output: [1,1]
 * <p>
 * Constraints:
 * <p>
 * 0 <= rowIndex <= 33
 * <p>
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
        System.out.println(new Solution().getRow(0));
        System.out.println(new Solution().getRow(1));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long temp = 1;
        for (int i = 1, up = rowIndex, down = 1; i <= rowIndex; i++, up--, down++) {
            temp = temp * up / down;
            ans.add((int) temp);
        }
        return ans;
    }
}