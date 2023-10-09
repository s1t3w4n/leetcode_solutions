import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (nums[l] == target && nums[r] == target) {
                    return new int[]{l, r};
                }
                if (nums[l] < target) {
                    l++;
                }
                if (nums[r] > target) {
                    r--;
                }
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}