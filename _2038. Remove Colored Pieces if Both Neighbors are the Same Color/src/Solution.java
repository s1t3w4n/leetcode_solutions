/**
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 * <p>
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 * <p>
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 * <p>
 * Example 1:
 * <p>
 * Input: colors = "AAABABB"
 * Output: true
 * Explanation:
 * AAABABB -> AABABB
 * Alice moves first.
 * She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
 * <p>
 * Now it's Bob's turn.
 * Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
 * Thus, Alice wins, so return true.
 * Example 2:
 * <p>
 * Input: colors = "AA"
 * Output: false
 * Explanation:
 * Alice has her turn first.
 * There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
 * Thus, Bob wins, so return false.
 * Example 3:
 * <p>
 * Input: colors = "ABBBBBBBAAA"
 * Output: false
 * Explanation:
 * ABBBBBBBAAA -> ABBBBBBBAA
 * Alice moves first.
 * Her only option is to remove the second to last 'A' from the right.
 * <p>
 * ABBBBBBBAA -> ABBBBBBAA
 * Next is Bob's turn.
 * He has many options for which 'B' piece to remove. He can pick any.
 * <p>
 * On Alice's second turn, she has no more pieces that she can remove.
 * Thus, Bob wins, so return false.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= colors.length <= 10^5
 * colors consists of only the letters 'A' and 'B'
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().winnerOfGame("AAABABB"));
        System.out.println(new Solution().winnerOfGame("AA"));
        System.out.println(new Solution().winnerOfGame("ABBBBBBBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        int aStringCount = 0, bStringCount = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A')
                aStringCount++;
            if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B')
                bStringCount++;
        }
        return aStringCount > bStringCount;
    }
}