import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There is a dungeon with n x m rooms arranged as a grid.
 * <p>
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.
 * <p>
 * Return the minimum time to reach the room (n - 1, m - 1).
 * <p>
 * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
 * <p>
 * Example 1:
 * <p>
 * Input: moveTime = [[0,4],[4,4]]
 * <p>
 * Output: 6
 * <p>
 * Explanation:
 * <p>
 * The minimum time required is 6 seconds.
 * <p>
 * At time t == 4, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 5, move from room (1, 0) to room (1, 1) in one second.
 * Example 2:
 * <p>
 * Input: moveTime = [[0,0,0],[0,0,0]]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The minimum time required is 3 seconds.
 * <p>
 * At time t == 0, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 1, move from room (1, 0) to room (1, 1) in one second.
 * At time t == 2, move from room (1, 1) to room (1, 2) in one second.
 * Example 3:
 * <p>
 * Input: moveTime = [[0,1],[1,2]]
 * <p>
 * Output: 3
 * <p>
 * Constraints:
 * <p>
 * 2 <= n == moveTime.length <= 50
 * 2 <= m == moveTime[i].length <= 50
 * 0 <= moveTime[i][j] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        // 6
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 4},
                new int[]{4, 4}
        }));
        // 3
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0}
        }));
        // 3
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 1},
                new int[]{1, 2}
        }));
    }

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{ 0,  1},
            new int[]{ 1,  0},
            new int[]{-1,  0},
            new int[]{ 0, -1}
    };

    private int[] target;
    private boolean[][] visited;

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        target = new int[]{n - 1, m - 1};
        visited = new boolean[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (Boolean.FALSE.equals(q.isEmpty())) {
            int[] current = q.poll();
            if (isTarget(current[0], current[1])) {
                return current[2];
            }
            for (int[] d : DIRECTIONS) {
                int r = current[0] + d[0];
                int c = current[1] + d[1];
                if (isOutOfBoundsCoordinates(r, c)) {
                    continue;
                }
                if (isVisited(r, c)) {
                    continue;
                }
                visited[r][c] = true;
                q.offer(new int[]{r, c, Math.max(current[2], moveTime[r][c]) + 1});
            }
        }
        return -1;
    }

    private boolean isTarget(int currentN, int currentM) {
        return currentN == target[0] && currentM == target[1];
    }

    private boolean isOutOfBoundsCoordinates(int currentN, int currentM) {
        return currentN < 0 || currentN > target[0] || currentM < 0 || currentM > target[1];
    }

    private boolean isVisited(int currentN, int currentM) {
        return visited[currentN][currentM];
    }
}