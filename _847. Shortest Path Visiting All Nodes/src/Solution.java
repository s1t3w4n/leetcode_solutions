import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
 * <p>
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 * Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * Constraints:
 * <p>
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] does not contain i.
 * If graph[a] contains b, then graph[b] contains a.
 * The input graph is always connected.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPathLength(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{0},
                        new int[]{0},
                        new int[]{0}
                }));
        System.out.println(new Solution().shortestPathLength(
                new int[][]{
                        new int[]{1},
                        new int[]{0, 2, 4},
                        new int[]{1, 3, 4},
                        new int[]{2},
                        new int[]{1, 2}
                }));
    }

    public int shortestPathLength(int[][] graph) {
        final int nodes = graph.length;
        final int goal = (1 << nodes) - 1;
        int answer = 0;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        boolean[][] seen = new boolean[nodes][1 << nodes];
        for (int i = 0; i < nodes; ++i) {
            queue.offer(new Pair<>(i, 1 << i));
        }
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; --size) {
                final int key = Objects.requireNonNull(queue.peek()).getKey();
                final int state = Objects.requireNonNull(queue.poll()).getValue();
                if (state == goal)
                    return answer;
                if (seen[key][state])
                    continue;
                seen[key][state] = true;
                for (final int v : graph[key])
                    queue.offer(new Pair<>(v, state | (1 << v)));
            }
            ++answer;
        }
        return -1;
    }
}