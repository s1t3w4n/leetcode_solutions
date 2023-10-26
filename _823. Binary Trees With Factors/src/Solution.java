import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,4]
 * Output: 3
 * Explanation: We can make these trees: [2], [4], [4, 2, 2]
 * Example 2:
 * <p>
 * Input: arr = [2,4,5,10]
 * Output: 7
 * Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * All the values of arr are unique.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        long answer = 1;
        map.put(arr[0], answer);
        for (int i = 1; i < arr.length; i++) {
            long summary = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j]))
                    summary = summary + (map.get(arr[i] / arr[j]) * map.get(arr[j]));
            }
            map.put(arr[i], summary);
            answer = answer + summary;
        }
        return (int) (answer % 1000000007);
    }
}