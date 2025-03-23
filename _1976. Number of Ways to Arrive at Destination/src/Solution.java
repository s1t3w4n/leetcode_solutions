import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * Example 2:
 * <p>
 * Input: n = 2, roads = [[1,0,10]]
 * Output: 1
 * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 109
 * ui != vi
 * There is at most one road connecting any two intersections.
 * You can reach any intersection from any other intersection.
 */
public class Solution {
    public static void main(String[] args) {
        // 1
        System.out.println(new Solution().countPaths(
                2,
                new int[][]{
                        new int[]{1, 0, 10}
                }
        ));
        // 4
        System.out.println(new Solution().countPaths(
                7,
                new int[][]{
                        new int[]{0, 6, 7},
                        new int[]{0, 1, 2},
                        new int[]{1, 2, 3},
                        new int[]{1, 3, 3},
                        new int[]{6, 3, 3},
                        new int[]{3, 5, 1},
                        new int[]{6, 5, 1},
                        new int[]{2, 5, 1},
                        new int[]{0, 4, 5},
                        new int[]{4, 6, 2}
                }
        ));
        // too slow for leetcode =(, but result is correct
        System.out.println(new Solution().countPaths(
                29,
                new int[][]{
                        new int[]{1, 0, 7443},
                        new int[]{2, 1, 9509},
                        new int[]{3, 2, 8933},
                        new int[]{4, 3, 2714},
                        new int[]{2, 4, 11647},
                        new int[]{3, 5, 8349},
                        new int[]{5, 0, 34234},
                        new int[]{6, 4, 584},
                        new int[]{0, 6, 29183},
                        new int[]{3, 6, 3298},
                        new int[]{6, 2, 12231},
                        new int[]{1, 6, 21740},
                        new int[]{3, 7, 2990},
                        new int[]{5, 8, 7837},
                        new int[]{1, 8, 34628},
                        new int[]{6, 8, 12888},
                        new int[]{0, 8, 42071},
                        new int[]{9, 8, 1650},
                        new int[]{4, 9, 15122},
                        new int[]{9, 7, 14846},
                        new int[]{9, 5, 9487},
                        new int[]{9, 1, 36278},
                        new int[]{6, 9, 14538},
                        new int[]{9, 3, 17836},
                        new int[]{1, 10, 23672},
                        new int[]{10, 7, 2240},
                        new int[]{10, 4, 2516},
                        new int[]{7, 11, 20638},
                        new int[]{10, 11, 18398},
                        new int[]{4, 11, 20914},
                        new int[]{11, 9, 5792},
                        new int[]{11, 2, 32561},
                        new int[]{3, 11, 23628},
                        new int[]{1, 11, 42070},
                        new int[]{8, 11, 7442},
                        new int[]{5, 11, 15279},
                        new int[]{11, 6, 20330},
                        new int[]{12, 0, 54359},
                        new int[]{12, 2, 37407},
                        new int[]{12, 8, 12288},
                        new int[]{12, 4, 25760},
                        new int[]{12, 10, 23244},
                        new int[]{11, 12, 4846},
                        new int[]{9, 12, 10638},
                        new int[]{13, 5, 21367},
                        new int[]{13, 1, 48158},
                        new int[]{11, 13, 6088},
                        new int[]{13, 2, 38649},
                        new int[]{9, 13, 11880},
                        new int[]{7, 13, 26726},
                        new int[]{13, 4, 27002},
                        new int[]{13, 3, 29716},
                        new int[]{6, 13, 26418},
                        new int[]{8, 13, 13530},
                        new int[]{13, 12, 1242},
                        new int[]{13, 0, 55601},
                        new int[]{13, 10, 24486},
                        new int[]{14, 3, 32382},
                        new int[]{14, 11, 8754},
                        new int[]{14, 7, 29392},
                        new int[]{8, 14, 16196},
                        new int[]{15, 11, 7583},
                        new int[]{10, 15, 25981},
                        new int[]{14, 16, 8258},
                        new int[]{16, 3, 40640},
                        new int[]{10, 16, 35410},
                        new int[]{16, 12, 12166},
                        new int[]{8, 16, 24454},
                        new int[]{16, 4, 37926},
                        new int[]{5, 16, 32291},
                        new int[]{16, 2, 49573},
                        new int[]{9, 17, 30859},
                        new int[]{17, 13, 18979},
                        new int[]{3, 17, 48695},
                        new int[]{17, 11, 25067},
                        new int[]{17, 16, 8055},
                        new int[]{17, 10, 43465},
                        new int[]{17, 8, 32509},
                        new int[]{5, 17, 40346},
                        new int[]{1, 17, 67137},
                        new int[]{4, 17, 45981},
                        new int[]{15, 17, 17484},
                        new int[]{17, 6, 45397},
                        new int[]{18, 15, 1705},
                        new int[]{10, 18, 27686},
                        new int[]{4, 18, 30202},
                        new int[]{18, 6, 29618},
                        new int[]{18, 9, 15080},
                        new int[]{19, 0, 67141},
                        new int[]{18, 19, 8340},
                        new int[]{7, 19, 38266},
                        new int[]{19, 2, 50189},
                        new int[]{9, 20, 37879},
                        new int[]{4, 20, 53001},
                        new int[]{18, 20, 22799},
                        new int[]{20, 14, 23333},
                        new int[]{17, 20, 7020},
                        new int[]{0, 20, 81600},
                        new int[]{20, 12, 27241},
                        new int[]{20, 13, 25999},
                        new int[]{3, 20, 55715},
                        new int[]{2, 20, 64648},
                        new int[]{11, 21, 34704},
                        new int[]{13, 21, 28616},
                        new int[]{20, 21, 2617},
                        new int[]{7, 21, 55342},
                        new int[]{21, 17, 9637},
                        new int[]{21, 4, 55618},
                        new int[]{21, 0, 84217},
                        new int[]{21, 12, 29858},
                        new int[]{2, 21, 67265},
                        new int[]{21, 9, 40496},
                        new int[]{21, 5, 49983},
                        new int[]{16, 21, 17692},
                        new int[]{21, 6, 55034},
                        new int[]{21, 3, 58332},
                        new int[]{15, 21, 27121},
                        new int[]{8, 21, 42146},
                        new int[]{10, 21, 53102},
                        new int[]{21, 19, 17076},
                        new int[]{22, 5, 52055},
                        new int[]{1, 22, 78846},
                        new int[]{8, 22, 44218},
                        new int[]{22, 0, 86289},
                        new int[]{2, 22, 69337},
                        new int[]{16, 22, 19764},
                        new int[]{12, 22, 31930},
                        new int[]{22, 11, 36776},
                        new int[]{10, 22, 55174},
                        new int[]{14, 22, 28022},
                        new int[]{3, 22, 60404},
                        new int[]{22, 20, 4689},
                        new int[]{22, 6, 57106},
                        new int[]{15, 22, 29193},
                        new int[]{8, 23, 53441},
                        new int[]{23, 1, 88069},
                        new int[]{23, 19, 28371},
                        new int[]{23, 22, 9223},
                        new int[]{14, 23, 37245},
                        new int[]{6, 23, 66329},
                        new int[]{7, 23, 66637},
                        new int[]{0, 23, 95512},
                        new int[]{5, 23, 61278},
                        new int[]{23, 18, 36711},
                        new int[]{23, 20, 13912},
                        new int[]{23, 15, 38416},
                        new int[]{3, 23, 69627},
                        new int[]{23, 13, 39911},
                        new int[]{9, 23, 51791},
                        new int[]{24, 23, 2196},
                        new int[]{24, 4, 69109},
                        new int[]{24, 14, 39441},
                        new int[]{24, 1, 90265},
                        new int[]{24, 22, 11419},
                        new int[]{3, 24, 71823},
                        new int[]{20, 25, 18955},
                        new int[]{25, 8, 58484},
                        new int[]{4, 25, 71956},
                        new int[]{13, 25, 44954},
                        new int[]{25, 24, 2847},
                        new int[]{25, 21, 16338},
                        new int[]{25, 7, 71680},
                        new int[]{3, 25, 74670},
                        new int[]{12, 25, 46196},
                        new int[]{25, 10, 69440},
                        new int[]{25, 23, 5043},
                        new int[]{25, 1, 93112},
                        new int[]{25, 9, 56834},
                        new int[]{19, 25, 33414},
                        new int[]{25, 22, 14266},
                        new int[]{18, 25, 41754},
                        new int[]{25, 15, 43459},
                        new int[]{2, 25, 83603},
                        new int[]{6, 25, 71372},
                        new int[]{11, 25, 51042},
                        new int[]{26, 22, 17573},
                        new int[]{26, 0, 103862},
                        new int[]{26, 7, 74987},
                        new int[]{26, 3, 77977},
                        new int[]{21, 26, 19645},
                        new int[]{26, 12, 49503},
                        new int[]{25, 26, 3307},
                        new int[]{8, 26, 61791},
                        new int[]{26, 18, 45061},
                        new int[]{24, 26, 6154},
                        new int[]{26, 5, 69628},
                        new int[]{16, 26, 37337},
                        new int[]{26, 10, 72747},
                        new int[]{26, 1, 96419},
                        new int[]{26, 13, 48261},
                        new int[]{6, 26, 74679},
                        new int[]{26, 15, 46766},
                        new int[]{9, 26, 60141},
                        new int[]{14, 26, 45595},
                        new int[]{17, 26, 29282},
                        new int[]{26, 20, 22262},
                        new int[]{23, 26, 8350},
                        new int[]{4, 26, 75263},
                        new int[]{26, 19, 36721},
                        new int[]{26, 2, 86910},
                        new int[]{27, 25, 4616},
                        new int[]{27, 8, 63100},
                        new int[]{27, 24, 7463},
                        new int[]{15, 27, 48075},
                        new int[]{14, 27, 46904},
                        new int[]{27, 3, 79286},
                        new int[]{27, 2, 88219},
                        new int[]{28, 1, 103845},
                        new int[]{28, 25, 10733},
                        new int[]{16, 28, 44763},
                        new int[]{28, 3, 85403},
                        new int[]{28, 14, 53021},
                        new int[]{7, 28, 82413},
                        new int[]{27, 28, 6117},
                        new int[]{15, 28, 54192},
                        new int[]{28, 5, 77054},
                        new int[]{6, 28, 82105},
                        new int[]{28, 8, 69217},
                        new int[]{24, 28, 13580},
                        new int[]{2, 28, 94336},
                        new int[]{10, 28, 80173},
                        new int[]{28, 26, 7426},
                        new int[]{28, 22, 24999},
                        new int[]{28, 11, 61775},
                        new int[]{28, 19, 44147},
                        new int[]{28, 23, 15776},
                        new int[]{28, 12, 56929},
                        new int[]{28, 13, 55687},
                        new int[]{4, 28, 82689}
                }
        ));
    }

    private int min = Integer.MAX_VALUE;
    private int count = 0;

    public int countPaths(int n, int[][] roads) {
        int start = 0;
        int end = n - 1;
        List<List<Map<Integer, Integer>>> graphWithTime = IntStream.range(0, n)
                .mapToObj(v -> new ArrayList<Map<Integer, Integer>>())
                .collect(Collectors.toList());
        for (int[] road : roads) {
            graphWithTime.get(road[0]).add(Collections.singletonMap(road[1], road[2]));
            graphWithTime.get(road[1]).add(Collections.singletonMap(road[0], road[2]));
        }
        dfs(start, end, 0, new HashSet<>(), graphWithTime);
        return count;
    }

    private void dfs(int current,
                     int end,
                     int sum,
                     HashSet<Integer> visited,
                     List<List<Map<Integer, Integer>>> graphWithTime) {
        if (sum > min) {
            return;
        }
        if (current == end) {
            if (min > sum) {
                count = 0;
                min = sum;
            }
            count++;
            return;
        }
        visited.add(current);
        for (Map<Integer, Integer> destination : graphWithTime.get(current)) {
            for (Map.Entry<Integer, Integer> entry : destination.entrySet()) {
                if (visited.contains(entry.getKey())) {
                    continue;
                }
                dfs(entry.getKey(), end, sum + entry.getValue(), new HashSet<>(visited), graphWithTime);
            }
        }
    }
}