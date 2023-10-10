import java.util.Arrays;
import java.util.HashSet;

/**
 * You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
 * <p>
 * nums is considered continuous if both of the following conditions are fulfilled:
 * <p>
 * All elements in nums are unique.
 * The difference between the maximum element and the minimum element in nums equals nums.length - 1.
 * For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
 * <p>
 * Return the minimum number of operations to make nums continuous.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,5,3]
 * Output: 0
 * Explanation: nums is already continuous.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5,6]
 * Output: 1
 * Explanation: One possible solution is to change the last element to 4.
 * The resulting array is [1,2,3,5,4], which is continuous.
 * Example 3:
 * <p>
 * Input: nums = [1,10,100,1000]
 * Output: 3
 * Explanation: One possible solution is to:
 * - Change the second element to 2.
 * - Change the third element to 3.
 * - Change the fourth element to 4.
 * The resulting array is [1,2,3,4], which is continuous.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(new Solution().minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(new Solution().minOperations(new int[]{1, 10, 100, 1000}));
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int answer = n;
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int[] newNums = new int[unique.size()];
        int index = 0;
        for (int num : unique) {
            newNums[index++] = num;
        }
        Arrays.sort(newNums);
        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i] + n) {
                j++;
            }

            int count = j - i;
            answer = Math.min(answer, n - count);
        }
        return answer;
    }
}