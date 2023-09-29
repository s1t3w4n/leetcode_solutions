/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 * <p>
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [6,5,4,4]
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,3,2]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(new Solution().isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(new Solution().isMonotonic(new int[]{1, 3, 2}));
    }

    public boolean isMonotonic(int[] nums) {
        boolean flag = false;
        boolean isAscMonotonic = false;
        for (int i = 1; i < nums.length; i++) {
            if (flag) {
                if (isAscMonotonic && nums[i] < nums[i - 1]) {
                    return false;
                }
                if (!isAscMonotonic && nums[i] > nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    isAscMonotonic = true;
                    flag = true;
                } else if (nums[i] < nums[i - 1]) {
                    flag = true;
                }
            }
        }
        return true;
    }
}