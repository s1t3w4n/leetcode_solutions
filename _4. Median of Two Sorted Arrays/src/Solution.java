/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2;
        int i, j;
        int lo = 0, hi = Math.min(k, m);
        while (true) {
            i = lo + (hi - lo) / 2;
            j = k - i;
            if (get(nums1, i) >= get(nums2, j - 1)) {
                if (get(nums2, j) >= get(nums1, i - 1)) break;
                else hi = i - 1;
            } else lo = i + 1;
        }
        if ((m + n) % 2 == 1) return Math.min(get(nums1, i), get(nums2, j));
        return (double) (Math.min(get(nums1, i), get(nums2, j)) + Math.max(get(nums1, i - 1), get(nums2, j - 1))) / 2;
    }

    private int get(int[] nums, int i) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}