/**
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
 * <p>
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 * <p>
 * In one operation, you can recolor a white block such that it becomes a black block.
 * <p>
 * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: blocks = "WBBWWBBWBW", k = 7
 * Output: 3
 * Explanation:
 * One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
 * so that blocks = "BBBBBBBWBW".
 * It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 * Therefore, we return 3.
 * Example 2:
 * <p>
 * Input: blocks = "WBWBBBW", k = 2
 * Output: 0
 * Explanation:
 * No changes need to be made, since 2 consecutive black blocks already exist.
 * Therefore, we return 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] is either 'W' or 'B'.
 * 1 <= k <= n
 */
class Solution {
    public static void main(String[] args) {
        // 3
        System.out.println(new Solution().minimumRecolors("WBBWWBBWBW", 7));
        // 0
        System.out.println(new Solution().minimumRecolors("WBWBBBW", 2));
        // 6
        System.out.println(new Solution().minimumRecolors("WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW", 15));
    }

    public int minimumRecolors(String blocks, int k) {
        int maxCount= 0;
        int bCount= 0;
        for(int i = 0;i < blocks.length();i++) {
            if (i > k - 1 && blocks.charAt(i - k) == 'B') {
                bCount--;
            }
            if(blocks.charAt(i) == 'B') {
                bCount++;
                if(bCount >= k) {
                    return 0;
                }
            }
            maxCount = Math.max(maxCount, bCount);
        }
        return Math.max(0, k - maxCount);
    }
}