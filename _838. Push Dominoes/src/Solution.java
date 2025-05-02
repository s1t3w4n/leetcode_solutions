/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * <p>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * <p>
 * You are given a string dominoes representing the initial state where:
 * <p>
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * Return a string representing the final state.
 * <p>
 * Example 1:
 * <p>
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * Example 2:
 * <p>
 * Input: dominoes = ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * <p>
 * Constraints:
 * <p>
 * n == dominoes.length
 * 1 <= n <= 10^5
 * dominoes[i] is either 'L', 'R', or '.'.
 */
public class Solution {
    public static void main(String[] args) {
        // RR.L
        System.out.println(new Solution().pushDominoes("RR.L"));
        // LL.RR.LLRRLL..
        System.out.println(new Solution().pushDominoes(".L.R...LR..L.."));
        // LR
        System.out.println(new Solution().pushDominoes("LR"));
    }

    public String pushDominoes(String dominoes) {
        if (dominoes.length() == 1) {
            return dominoes;
        }
        int count = 0, n = dominoes.length();
        boolean isFalling = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            switch (dominoes.charAt(i)) {
                case '.' -> count++;
                case 'R' -> {
                    if (isFalling) {
                        count++;
                        res.append("R".repeat(count));
                    } else {
                        res.append(".".repeat(count));
                        res.append('R');
                    }
                    count = 0;
                    isFalling = true;
                }
                case 'L' -> {
                    if (isFalling) {
                        res.append("R".repeat(count / 2));
                        if (count % 2 == 1) {
                            res.append('.');
                        }
                        res.append("L".repeat((count / 2) + 1));
                    } else {
                        count++;
                        res.append("L".repeat(count));
                    }
                    count = 0;
                    isFalling = false;
                }
            }
        }
        res.append((isFalling ? "R" : ".").repeat(count));
        return res.toString();
    }
}