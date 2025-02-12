import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 * <p>
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [18,43,36,13,7]
 * Output: 54
 * Explanation: The pairs (i, j) that satisfy the conditions are:
 * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
 * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
 * So the maximum sum that we can obtain is 54.
 * Example 2:
 * <p>
 * Input: nums = [10,12,19,14]
 * Output: -1
 * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().maximumSum(new int[]{18, 43, 36, 13, 7})); // 54
        System.out.println(new Solution2().maximumSum(new int[]{10, 12, 19, 14})); // -1
        System.out.println(new Solution2().maximumSum(new int[]{368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183})); // 835
        System.out.println(new Solution2().maximumSum(new int[]{383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5})); // 460
        System.out.println(new Solution2().maximumSum(new int[]{229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401})); // 973
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumToMaxElement = new HashMap<>();
        int maxSum = -1;
        for (int num : nums) {
            int temp = num;
            int dSum = 0;
            while (temp != 0) {
                dSum += temp % 10;
                temp = temp / 10;
            }
            if (sumToMaxElement.containsKey(dSum)) {
                maxSum = Math.max(maxSum, num + sumToMaxElement.get(dSum));
                sumToMaxElement.put(dSum, Math.max(num, sumToMaxElement.get(dSum)));
            } else {
                sumToMaxElement.put(dSum, num);
            }
        }
        return maxSum;
    }
}