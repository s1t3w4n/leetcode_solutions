/**
 * You are given a binary array nums.
 * <p>
 * You can do the following operation on the array any number of times (possibly zero):
 * <p>
 * Choose any 3 consecutive elements from the array and flip all of them.
 * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
 * <p>
 * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,1,1,0,0]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * We can do the following operations:
 * <p>
 * Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
 * Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
 * Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 * Example 2:
 * <p>
 * Input: nums = [0,1,1,1]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * It is impossible to make all elements equal to 1.
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 10^5
 * 0 <= nums[i] <= 1
 */
public class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().minOperations(new int[]{0,1,1,1,0,0}));
        // -1
        System.out.println(new Solution().minOperations(new int[]{0,1,1,1}));
    }

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                count++;
            }
        }
        if (nums[nums.length - 1] == 0) {
            return -1;
        }
        if (nums[nums.length - 2] == 0) {
            return -1;
        }
        return count;
    }
}