import java.util.Arrays;

/**
 * You are given a 0-indexed array nums of size n consisting of non-negative integers.
 * <p>
 * You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:
 * <p>
 * If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
 * After performing all the operations, shift all the 0's to the end of the array.
 * <p>
 * For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
 * Return the resulting array.
 * <p>
 * Note that the operations are applied sequentially, not all at once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,1,1,0]
 * Output: [1,4,2,0,0,0]
 * Explanation: We do the following operations:
 * - i = 0: nums[0] and nums[1] are not equal, so we skip this operation.
 * - i = 1: nums[1] and nums[2] are equal, we multiply nums[1] by 2 and change nums[2] to 0. The array becomes [1,4,0,1,1,0].
 * - i = 2: nums[2] and nums[3] are not equal, so we skip this operation.
 * - i = 3: nums[3] and nums[4] are equal, we multiply nums[3] by 2 and change nums[4] to 0. The array becomes [1,4,0,2,0,0].
 * - i = 4: nums[4] and nums[5] are equal, we multiply nums[4] by 2 and change nums[5] to 0. The array becomes [1,4,0,2,0,0].
 * After that, we shift the 0's to the end, which gives the array [1,4,2,0,0,0].
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [1,0]
 * Explanation: No operation can be applied, we just shift the 0 to the end.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{0, 1})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 27})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{312, 312, 436, 892, 0, 0, 528, 0, 686, 516, 0, 0, 0, 0, 0, 445, 445, 445, 445, 445, 445, 984, 984, 984, 0, 0, 0, 0, 168, 0, 0, 647, 41, 203, 203, 241, 241, 0, 628, 628, 0, 875, 875, 0, 0, 0, 803, 803, 54, 54, 852, 0, 0, 0, 958, 195, 590, 300, 126, 0, 0, 523, 523})));
    }

    public int[] applyOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }
        if (count != nums.length) {
            int temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[count];
            nums[count] = temp;
        }
        return nums;
    }
}