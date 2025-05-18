import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class Solution {
    public static void main(String[] args) {
        // [0,0,1,1,2,2]
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        // [0,1,2]
        int[] nums2= {2,0,1};
        new Solution().sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int current = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[current] > arr[i]) {
                int tmp = arr[current];
                arr[current] = arr[i];
                arr[i] = arr[current + 1];
                arr[current + 1] = tmp;
                current = current + 1;
            }
        }
        quickSort(arr, start, current - 1);
        quickSort(arr, current + 1, end);
    }
}