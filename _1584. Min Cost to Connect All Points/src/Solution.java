import java.util.Arrays;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * <p>
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 * <p>
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= points.length <= 1000
 * -10^6 <= xi, yi <= 10^6
 * All pairs (xi, yi) are distinct.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minCostConnectPoints(new int[][]{
                new int[]{0, 0},
                new int[]{2, 2},
                new int[]{3, 10},
                new int[]{5, 2},
                new int[]{7, 0}}
        ));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{
                new int[]{3, 12},
                new int[]{-2, 5},
                new int[]{-4, 1}}
        ));
    }

    public int minCostConnectPoints(int[][] points) {
        int[] distance = new int[points.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int answer = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                distance[j] = Math.min(distance[j], Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]));
                if (distance[j] < distance[i + 1]) {
                    final int[] tempPoint = points[j];
                    points[j] = points[i + 1];
                    points[i + 1] = tempPoint;
                    final int tempDistance = distance[j];
                    distance[j] = distance[i + 1];
                    distance[i + 1] = tempDistance;
                }
            }
            answer += distance[i + 1];
        }
        return answer;
    }
}