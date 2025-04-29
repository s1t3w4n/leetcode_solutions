/**
 * You are given an integer array nums and a positive integer k.
 * <p>
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 * <p>
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= k <= 10^5
 */
public class Solution {
    public static void main(String[] args) {
        // 6
        System.out.println(new Solution().countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        // 0
        System.out.println(new Solution().countSubarrays(new int[]{1, 4, 2, 1}, 3));
        // 9
        System.out.println(new Solution().countSubarrays(new int[]{5, 14, 36, 25, 23, 8, 38, 38, 42, 42}, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int n = nums.length;
        int max = 0, mCount = 0;
        for (int start = 0, end = 0; end < n; end++) {
            if (max < nums[end]) {
                max = nums[end];
                mCount = 0;
                count = 0;
                start = 0;
            }
            if (nums[end] == max) {
                mCount++;
            }
            while (mCount == k) {
                if (nums[start] == max) {
                    mCount--;
                }
                start++;
            }
            count += start;
        }
        return count;
    }
}