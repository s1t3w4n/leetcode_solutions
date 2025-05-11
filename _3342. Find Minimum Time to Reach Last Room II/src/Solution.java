import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There is a dungeon with n x m rooms arranged as a grid.
 * <p>
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.
 * <p>
 * Return the minimum time to reach the room (n - 1, m - 1).
 * <p>
 * Two rooms are adjacent if they share a common wall, either horizontally or vertically.
 * <p>
 * Example 1:
 * <p>
 * Input: moveTime = [[0,4],[4,4]]
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * <p>
 * The minimum time required is 7 seconds.
 * <p>
 * At time t == 4, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
 * Example 2:
 * <p>
 * Input: moveTime = [[0,0,0,0],[0,0,0,0]]
 * <p>
 * Output: 6
 * <p>
 * Explanation:
 * <p>
 * The minimum time required is 6 seconds.
 * <p>
 * At time t == 0, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 1, move from room (1, 0) to room (1, 1) in two seconds.
 * At time t == 3, move from room (1, 1) to room (1, 2) in one second.
 * At time t == 4, move from room (1, 2) to room (1, 3) in two seconds.
 * Example 3:
 * <p>
 * Input: moveTime = [[0,1],[1,2]]
 * <p>
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 2 <= n == moveTime.length <= 750
 * 2 <= m == moveTime[i].length <= 750
 * 0 <= moveTime[i][j] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        // 7
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 4},
                new int[]{4, 4}
        }));
        // 6
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0}
        }));
        // 4
        System.out.println(new Solution().minTimeToReach(new int[][]{
                new int[]{0, 1},
                new int[]{1, 2}
        }));
    }

    private static final int[][] DIRECTIONS =
            new int[][]{
                    new int[]{ 0,  1},
                    new int[]{ 0, -1},
                    new int[]{-1,  0},
                    new int[]{ 1,  0}
            };

    private int nTarget, mTarget;
    private boolean[][] visited;

    public int minTimeToReach(int[][] moveTime) {
        nTarget = moveTime.length - 1;
        mTarget = moveTime[0].length - 1;
        visited = new boolean[nTarget + 1][mTarget + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while(Boolean.FALSE.equals(q.isEmpty())) {
            int[] current = q.poll();
            if(isTarget(current)) {
                return current[2];
            }
            int et = ((current[0] + current[1]) % 2) + 1;
            for(int[] d: DIRECTIONS) {
                int n = current[0] + d[0], m = current[1] + d[1];
                if (isOutOfBounds(n , m)) {
                    continue;
                }
                if (isVisited(n , m)) {
                    continue;
                }
                visited[n][m] = true;
                q.offer(new int[]{ n, m, Math.max(current[2], moveTime[n][m]) + et});
            }
        }
        return -1;
    }

    private boolean isTarget(int[] potentialTarget) {
        return potentialTarget[0] == nTarget && potentialTarget[1] == mTarget;
    }

    private boolean isOutOfBounds(int potentialN, int potentialM) {
        return potentialN < 0 || potentialN > nTarget || potentialM < 0 || potentialM > mTarget;
    }

    private boolean isVisited(int potentialN, int potentialM) {
        return visited[potentialN][potentialM];
    }
}