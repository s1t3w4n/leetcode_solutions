import java.util.Arrays;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{0})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{0,2})));
    }

    public int[] sortArrayByParity(int[] nums) {
        int fistOddIndex = 0;
        for (int i = nums.length - 1; i > fistOddIndex; i--) {
            while (nums[fistOddIndex] % 2 == 0 && fistOddIndex != i) {
                fistOddIndex++;
            }
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[fistOddIndex];
                nums[fistOddIndex] = temp;
            }
        }
        return nums;
    }
}