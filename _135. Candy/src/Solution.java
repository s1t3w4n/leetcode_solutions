import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p>
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 0, 2}));
        System.out.println(new Solution().candy(new int[]{1, 2, 2}));
    }

    public int candy(int[] ratings) {
        int totalCandies = 0;
        int[] distribution = new int[ratings.length];
        Arrays.fill(distribution, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                distribution[i + 1] = distribution[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (distribution[i - 1] <= distribution[i]) {
                    distribution[i - 1] = distribution[i] + 1;
                }
            }
        }
        for (int dist : distribution) {
            totalCandies += dist;
        }
        return totalCandies;
    }
}