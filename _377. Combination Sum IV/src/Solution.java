import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * <p>
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 * <p>
 * Input: nums = [9], target = 3
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * <p>
 * <p>
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(new Solution().combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        Set<Integer> allNumbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> summaries = new HashMap<>();
        for (int i = 1; i <= target; i++) {
            int currentSum = 0;
            for (int num : allNumbers) {
                currentSum += summaries.getOrDefault(i - num, 0);
            }
            if (allNumbers.contains(i)) {
                currentSum++;
            }
            summaries.put(i, currentSum);
        }
        return summaries.get(target);
    }
}