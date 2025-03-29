import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given an m x n integer matrix grid and an array queries of size k.
 * <p>
 * Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:
 * <p>
 * If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
 * Otherwise, you do not get any points, and you end this process.
 * After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.
 * <p>
 * Return the resulting array answer.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
 * Output: [5,8,1]
 * Explanation: The diagrams above show which cells we visit to get points for each query.
 * Example 2:
 * <p>
 * Input: grid = [[5,2,1],[1,1,2]], queries = [3]
 * Output: [0]
 * Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 10^5
 * k == queries.length
 * 1 <= k <= 10^4
 * 1 <= grid[i][j], queries[i] <= 10^6
 */
public class Solution {
    public static void main(String[] args) {
        // [5,8,1]
        System.out.println(Arrays.toString(new Solution().maxPoints(new int[][]{
                new int[]{1, 2, 3},
                new int[]{2, 5, 7},
                new int[]{3, 5, 1}
        }, new int[]{5, 6, 2})));
        // [0]
        System.out.println(Arrays.toString(new Solution().maxPoints(new int[][]{
                new int[]{5, 2, 1},
                new int[]{1, 1, 2}
        }, new int[]{3})));

    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int yLength = grid.length;
        int xLength = grid[0].length;
        int qLength = queries.length;
        int[] answer = new int[qLength];
        LinkedList<int[]> query = new LinkedList<>();
        HashMap<Integer, Set<Integer>> visited = new HashMap<>();
        addNext(0, 0, yLength, xLength, query, visited);
        LinkedList<int[]> nextQuery = new LinkedList<>();
        Map<Integer, Integer> queryToLength = IntStream.range(0, qLength).boxed()
                .sorted(Comparator.comparingInt(i -> queries[i]))
                .collect(Collectors.toMap(
                        Function.identity(), i -> queries[i],
                        (oldVal, newVal) -> oldVal, LinkedHashMap::new));
        Integer prevIndex = null;
        for (Map.Entry<Integer, Integer> entry : queryToLength.entrySet()) {
            if (prevIndex != null) {
                answer[entry.getKey()] = answer[prevIndex];
                if (queries[prevIndex] == queries[entry.getKey()]) {
                    continue;
                }
            }
            prevIndex = entry.getKey();
            query.addAll(nextQuery);
            nextQuery.clear();
            while (Boolean.FALSE.equals(query.isEmpty())) {
                int[] current = query.poll();
                if (entry.getValue() > grid[current[0]][current[1]]) {
                    answer[entry.getKey()]++;
                    addNext(current[0] + 1, current[1], yLength, xLength, query, visited);
                    addNext(current[0] - 1, current[1], yLength, xLength, query, visited);
                    addNext(current[0], current[1] + 1, yLength, xLength, query, visited);
                    addNext(current[0], current[1] - 1, yLength, xLength, query, visited);
                } else {
                    nextQuery.add(current);
                }
            }
        }
        return answer;
    }

    private void addNext(int y,
                         int x,
                         int yLength,
                         int xLength,
                         LinkedList<int[]> query,
                         HashMap<Integer, Set<Integer>> visited) {
        if (y > yLength - 1 || y < 0) {
            return;
        }
        if (x > xLength - 1 || x < 0) {
            return;
        }
        if (visited.containsKey(y) && visited.get(y).contains(x)) {
            return;
        }
        visited.computeIfAbsent(y, HashSet::new).add(x);
        query.add(new int[]{y, x});
    }
}