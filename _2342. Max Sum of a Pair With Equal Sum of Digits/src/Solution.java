import java.util.HashMap;
import java.util.PriorityQueue;

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
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{18, 43, 36, 13, 7})); // 54
        System.out.println(new Solution().maximumSum(new int[]{10, 12, 19, 14})); // -1
        System.out.println(new Solution().maximumSum(new int[]{368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183})); // 835
        System.out.println(new Solution().maximumSum(new int[]{383, 77, 97, 261, 102, 344, 150, 130, 55, 337, 401, 498, 21, 5})); // 460
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> sumToIndexes = new HashMap<>();
        for (int num : nums) {
            int sum = sumOfDigits(num);
            if (Boolean.FALSE.equals(sumToIndexes.containsKey(sum))) {
                sumToIndexes.put(sum, new PriorityQueue<>());
            }
            add(sumToIndexes.get(sum), num);
        }
        return sumToIndexes.values().stream()
                .filter(integers -> integers.size() > 1)
                .mapToInt(integers -> integers.stream().mapToInt(Integer::intValue).sum())
                .max().orElse(-1);
    }

    private static void add(PriorityQueue<Integer> queue, int num) {
        queue.offer(num);
        if (queue.size() > 2) {
            queue.poll();
        }
    }

    private static int sumOfDigits(int num) {
        String s = Integer.toString(num);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }
}