/**
 * You are given an array of integers nums (0-indexed) and an integer k.
 * <p>
 * The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.
 * <p>
 * Return the maximum possible score of a good subarray.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,4,3,7,4,5], k = 3
 * Output: 15
 * Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15.
 * Example 2:
 * <p>
 * Input: nums = [5,5,4,5,4,1,1,1], k = 0
 * Output: 20
 * Explanation: The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 2 * 10^4
 * 0 <= k < nums.length
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(new Solution().maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int ans = nums[k];
        int currMin = nums[k];

        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1] : 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                currMin = Math.min(currMin, nums[right]);
            } else {
                left--;
                currMin = Math.min(currMin, nums[left]);
            }

            ans = Math.max(ans, currMin * (right - left + 1));
        }

        return ans;
    }
}