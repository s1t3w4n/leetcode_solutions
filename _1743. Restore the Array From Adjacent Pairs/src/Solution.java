import java.util.*;

/**
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 * <p>
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 * <p>
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 * <p>
 * Return the original array nums. If there are multiple solutions, return any of them.
 * <p>
 * Example 1:
 * <p>
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 * <p>
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 * <p>
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 * <p>
 * Constraints:
 * <p>
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 10^5
 * -10^5 <= nums[i], ui, vi <= 10^5
 * There exists some nums that has adjacentPairs as its pairs.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                new int[]{2, 1},
                new int[]{3, 2},
                new int[]{3, 4}
        })));
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                new int[]{4,-2},
                new int[]{1,4},
                new int[]{-3,1}
        })));
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                new int[]{100000,-100000}
        })));
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] ans = new int[graph.size()];
        dfs(root, Integer.MAX_VALUE, ans, 0);
        return ans;
    }

    private void dfs(int node, int prev, int[] ans, int i) {
        ans[i] = node;
        for (int neighbor : graph.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, ans, i + 1);
            }
        }
    }
}