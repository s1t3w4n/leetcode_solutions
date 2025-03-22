import java.util.*;

/**
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 * <p>
 * Return the number of complete connected components of the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * <p>
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 * Output: 3
 * Explanation: From the picture above, one can see that all of the components of this graph are complete.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * Output: 1
 * Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 * 0 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * There are no repeated edges.
 */
public class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().countCompleteComponents(6,
                new int[][]{
                        new int[]{0,1},
                        new int[]{0,2},
                        new int[]{1,2},
                        new int[]{3,4}
                }));
        // 1
        System.out.println(new Solution().countCompleteComponents(6,
                new int[][]{
                        new int[]{0,1},
                        new int[]{0,2},
                        new int[]{1,2},
                        new int[]{3,4},
                        new int[]{3,5}
                }));
        // 0
        System.out.println(new Solution().countCompleteComponents(3,
                new int[][]{
                        new int[]{0,1},
                        new int[]{2,1}
                }));
    }

    private HashMap<Integer, Set<Integer>> nodeToEdges;
    private HashSet<Integer> used;

    public int countCompleteComponents(int n, int[][] edges) {
        nodeToEdges = new HashMap<>(n);
        for (int[] edge : edges) {
            nodeToEdges.computeIfAbsent(edge[0], HashSet::new).add(edge[1]);
            nodeToEdges.computeIfAbsent(edge[1], HashSet::new).add(edge[0]);
        }
        int count = 0;
        used = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            if (used.contains(i)) {
                continue;
            }
            if (isComplete(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isComplete(int node) {
        if (nodeToEdges.containsKey(node)) {
            HashSet<Integer> connections = new HashSet<>(nodeToEdges.get(node));
            used.addAll(connections);
            for (Integer i : nodeToEdges.get(node)) {
                Set<Integer> iCon = nodeToEdges.get(i);
                connections.remove(i);
                iCon.remove(node);
                if (connections.size() != iCon.size()) {
                    connections.add(i);
                    iCon.add(node);
                    return false;
                }
                if (Boolean.FALSE.equals(connections.containsAll(iCon))) {
                    connections.add(i);
                    iCon.add(node);
                    return false;
                }
                connections.add(i);
            }
        }
        return true;
    }
}