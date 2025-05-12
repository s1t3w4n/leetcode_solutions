import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an integer array digits, where each element is a digit. The array may contain duplicates.
 * <p>
 * You need to find all the unique integers that follow the given requirements:
 * <p>
 * The integer consists of the concatenation of three elements from digits in any arbitrary order.
 * The integer does not have leading zeros.
 * The integer is even.
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
 * <p>
 * Return a sorted array of the unique integers.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [2,1,3,0]
 * Output: [102,120,130,132,210,230,302,310,312,320]
 * Explanation: All the possible integers that follow the requirements are in the output array.
 * Notice that there are no odd integers or integers with leading zeros.
 * Example 2:
 * <p>
 * Input: digits = [2,2,8,8,2]
 * Output: [222,228,282,288,822,828,882]
 * Explanation: The same digit can be used as many times as it appears in digits.
 * In this example, the digit 8 is used twice each time in 288, 828, and 882.
 * Example 3:
 * <p>
 * Input: digits = [3,7,5]
 * Output: []
 * Explanation: No even integers can be formed using the given digits.
 * <p>
 * Constraints:
 * <p>
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Solution {
    public static void main(String[] args) {
        // [102,120,130,132,210,230,302,310,312,320]
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 1, 3, 0})));
        // [222,228,282,288,822,828,882]
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
        // []
        System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{3, 7, 5})));
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        ArrayList<Integer> res = new ArrayList<>(900);
        for (int i = 1; i < 10; i++) {
            if (freq[i] < 1) {
                continue;
            }
            freq[i]--;
            for (int j = 0; j < 10; j++) {
                if (freq[j] < 1) {
                    continue;
                }
                freq[j]--;
                for (int k = 0; k < 10; k += 2) {
                    if (freq[k] < 1) {
                        continue;
                    }
                    res.add(i * 100 + j * 10 + k);
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}