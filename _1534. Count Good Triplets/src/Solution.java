/**
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 * <p>
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 * <p>
 * Return the number of good triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 * Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 * Example 2:
 * <p>
 * Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * Output: 0
 * Explanation: No triplet satisfies all conditions.
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class Solution {
    public static void main(String[] args) {
        // 4
        System.out.println(new Solution().countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        // 0
        System.out.println(new Solution().countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int ij = Math.abs(arr[i] - arr[j]);
                if (ij > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    int jk = Math.abs(arr[j] - arr[k]);
                    int ik = Math.abs(arr[i] - arr[k]);
                    if (jk <= b && ik <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}