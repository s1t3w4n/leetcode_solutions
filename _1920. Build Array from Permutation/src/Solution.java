import java.util.Arrays;

/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,2,1,5,3,4]
 * Output: [0,1,2,4,5,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * = [0,1,2,4,5,3]
 * Example 2:
 * <p>
 * Input: nums = [5,0,1,2,3,4]
 * Output: [4,5,0,1,2,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 * = [4,5,0,1,2,3]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * The elements in nums are distinct.
 * <p>
 * Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
 */
public class Solution {
    public static void main(String[] args) {
        // [0,1,2,4,5,3]
        System.out.println(Arrays.toString(new Solution().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
        // [4,5,0,1,2,3]
        System.out.println(Arrays.toString(new Solution().buildArray(new int[]{5, 0, 1, 2, 3, 4})));
    }

    public int[] buildArray(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}