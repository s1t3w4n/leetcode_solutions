import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.
 * <p>
 * Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.
 * <p>
 * Example 1:
 * <p>
 * Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
 * Output: [1,2,2,2]
 * Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
 * For each person, we return the number of flowers in full bloom during their arrival.
 * Example 2:
 * <p>
 * Input: flowers = [[1,10],[3,3]], poeple = [3,3,2]
 * Output: [2,2,1]
 * Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
 * For each person, we return the number of flowers in full bloom during their arrival.
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowers.length <= 5 * 10^4
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 10^9
 * 1 <= people.length <= 5 * 10^4
 * 1 <= people[i] <= 10^9
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().fullBloomFlowers(new int[][]{
                        new int[]{1, 6},
                        new int[]{3, 7},
                        new int[]{9, 12},
                        new int[]{4, 13}}
                , new int[]{2, 3, 7, 11})));
        System.out.println(Arrays.toString(new Solution().fullBloomFlowers(new int[][]{
                        new int[]{3,3},
                        new int[]{1,10}}
                , new int[]{3, 3, 2})));
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];
        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            int i = binarySearch(starts, person);
            int j = binarySearch(ends, person);
            ans[index] = i - j;
        }
        return ans;
    }

    public int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}