/**
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
 * <p>
 * Return the largest lucky integer in the array. If there is no lucky integer return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 * <p>
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 * <p>
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class Solution {
    public static void main(String[] args) {
        // 2
        System.out.println(new Solution().findLucky(new int[]{2, 2, 3, 4}));
        // 3
        System.out.println(new Solution().findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        //-1
        System.out.println(new Solution().findLucky(new int[]{2, 2, 2, 3, 3}));
    }

    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int a : arr) {
            freq[a]++;
        }
        for (int v = 500; v > 0; v--) {
            if (v == freq[v]) {
                return v;
            }
        }
        return -1;
    }
}