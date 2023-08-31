import java.util.Arrays;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 * <p>
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * <p>
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * <p>
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * Example 2:
 * <p>
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println(new Solution().minTaps(3, new int[]{0, 0, 0, 0}));
    }

    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0, canRichDistance = 0, count = 0;
        for (int i = 0; i <= n; i++) {
            if (i > end) {
                if (canRichDistance <= end) return -1;
                end = canRichDistance;
                count++;
            }
            canRichDistance = Math.max(canRichDistance, arr[i]);
        }

        return count + (end < n ? 1 : 0);
    }
}