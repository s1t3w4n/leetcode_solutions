import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums consisting of 2 * n integers.
 * <p>
 * You need to divide nums into n pairs such that:
 * <p>
 * Each element belongs to exactly one pair.
 * The elements present in a pair are equal.
 * Return true if nums can be divided into n pairs, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3,2,2,2]
 * Output: true
 * Explanation:
 * There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
 * If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums.length == 2 * n
 * 1 <= n <= 500
 * 1 <= nums[i] <= 500
 */
public class Solution {
    public static void main(String[] args) {
        // true
        System.out.println(new Solution().divideArray(new int[]{3,2,3,2,2,2}));
        // false
        System.out.println(new Solution().divideArray(new int[]{1,2,3,4}));
    }

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(Integer i: nums) {
            if(numToCount.containsKey(i))  {
                numToCount.put(i, numToCount.get(i) + 1);
            } else {
                numToCount.put(i, 1);
            }
        }
        for(Integer i: numToCount.values()) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}