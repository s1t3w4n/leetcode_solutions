/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1^st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * For example, for n = 3, the 1^st row is 0, the 2^nd row is 01, and the 3^rd row is 0110.
 * Given two integer n and k, return the k^th (1-indexed) symbol in the n^th row of a table of n rows.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, k = 1
 * Output: 0
 * Explanation: row 1: 0
 * Example 2:
 * <p>
 * Input: n = 2, k = 1
 * Output: 0
 * Explanation:
 * row 1: 0
 * row 2: 01
 * Example 3:
 * <p>
 * Input: n = 2, k = 2
 * Output: 1
 * Explanation:
 * row 1: 0
 * row 2: 01
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2^n - 1
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(1, 1));
        System.out.println(new Solution().kthGrammar(2, 1));
        System.out.println(new Solution().kthGrammar(2, 2));
    }

    public int kthGrammar(int n, int k) {
        return recursion(n, k);
    }

    public int recursion(int n, int k) {
        // First row will only have one symbol '0'.
        if (n == 1) {
            return 0;
        }

        int totalElements = (int) Math.pow(2, (n - 1));
        int halfElements = totalElements / 2;

        // If the target is present in the right half, we switch to the respective left half symbol.
        if (k > halfElements) {
            return 1 - recursion(n, k - halfElements);
        }

        // Otherwise, we switch to the previous row.
        return recursion(n - 1, k);
    }
}