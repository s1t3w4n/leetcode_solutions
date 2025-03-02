import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given two 2D integer arrays nums1 and nums2.
 * <p>
 * nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 * nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 * Each array contains unique ids and is sorted in ascending order by id.
 * <p>
 * Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
 * <p>
 * Only ids that appear in at least one of the two arrays should be included in the resulting array.
 * Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
 * Return the resulting array. The returned array must be sorted in ascending order by id.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 * Output: [[1,6],[2,3],[3,2],[4,6]]
 * Explanation: The resulting array contains the following:
 * - id = 1, the value of this id is 2 + 4 = 6.
 * - id = 2, the value of this id is 3.
 * - id = 3, the value of this id is 2.
 * - id = 4, the value of this id is 5 + 1 = 6.
 * Example 2:
 * <p>
 * Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 * Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
 * Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 200
 * nums1[i].length == nums2[j].length == 2
 * 1 <= idi, vali <= 1000
 * Both arrays contain unique ids.
 * Both arrays are in strictly ascending order by id.
 */
public class Solution {
    public static void main(String[] args) {
        // [[1,6],[2,3],[3,2],[4,6]]
        System.out.println(Arrays.deepToString(new Solution()
                .mergeArrays(
                        new int[][]{{1, 2}, {2, 3}, {4, 5}},
                        new int[][]{{1, 4}, {3, 2}, {4, 1}}
                )));
        // [[1,3],[2,4],[3,6],[4,3],[5,5]]
        System.out.println(Arrays.deepToString(new Solution()
                .mergeArrays(
                        new int[][]{{2, 4}, {3, 6}, {5, 5}},
                        new int[][]{{1, 3}, {4, 3}}
                )));
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> resultMap = new TreeMap<>();
        for (int[] ints : nums1) {
            resultMap.put(ints[0], ints[1]);
        }
        for (int[] ints : nums2) {
            if (resultMap.containsKey(ints[0])) {
                resultMap.put(ints[0], resultMap.get(ints[0]) + ints[1]);
            } else {
                resultMap.put(ints[0], ints[1]);
            }
        }
        int[][] result = new int[resultMap.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;
    }
}