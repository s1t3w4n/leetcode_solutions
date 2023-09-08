import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
        System.out.println(new Solution().generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temporary = new ArrayList<>();
            temporary.add(1);
            if (i > 0) {
                List<Integer> oneBeforeLast = result.get(i - 1);
                for (int j = 0; j < oneBeforeLast.size() - 1; j++) {
                    temporary.add(oneBeforeLast.get(j) + oneBeforeLast.get(j + 1));
                }
                temporary.add(1);
            }
            result.add(temporary);
        }
        return result;
    }
}