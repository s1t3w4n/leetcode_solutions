/**
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * Example 2:
 * <p>
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 */
public class Solution {
    public static void main(String[] args) {
        // false
        System.out.println(new Solution().threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        // true
        System.out.println(new Solution().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}