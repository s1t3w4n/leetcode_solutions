import java.util.*;

/**
 * You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
 * <p>
 * Every element less than pivot appears before every element greater than pivot.
 * Every element equal to pivot appears in between the elements less than and greater than pivot.
 * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
 * More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
 * Return nums after the rearrangement.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [9,12,5,10,14,3,10], pivot = 10
 * Output: [9,5,3,10,10,12,14]
 * Explanation:
 * The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
 * The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
 * The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
 * Example 2:
 * <p>
 * Input: nums = [-3,4,3,2], pivot = 2
 * Output: [-3,2,4,3]
 * Explanation:
 * The element -3 is less than the pivot so it is on the left side of the array.
 * The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
 * The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^6 <= nums[i] <= 10^6
 * pivot equals to an element of nums.
 */
public class Solution {
    public static void main(String[] args) {
        // 9,5,3,10,10,12,14
        System.out.println(Arrays.toString(new Solution().pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        // -3,2,4,3
        System.out.println(Arrays.toString(new Solution().pivotArray(new int[]{-3, 4, 3, 2}, 2)));

    }

    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> before = new LinkedList<>();
        Queue<Integer> after = new LinkedList<>();
        int eqCount = 0;
        for (int num : nums) {
            if (num < pivot) {
                before.add(num);
            }
            if (num > pivot) {
                after.add(num);
            }
            if (num == pivot) {
                eqCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Boolean.FALSE.equals(before.isEmpty())) {
                nums[i] = before.poll();
            } else if (eqCount > 0) {
                nums[i] = pivot;
                eqCount--;
            } else if (Boolean.FALSE.equals(after.isEmpty())) {
                nums[i] = after.poll();
            }
        }
        return nums;
    }
}