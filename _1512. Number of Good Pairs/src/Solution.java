import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums, return the number of good pairs.
 * <p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(new Solution().numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(new Solution().numIdenticalPairs(new int[]{1, 2, 3}));
    }

    public int numIdenticalPairs(int[] nums) {
        return (int) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToLong(x -> x)
                .map(x -> x * (x - 1) / 2)
                .sum();
    }
}