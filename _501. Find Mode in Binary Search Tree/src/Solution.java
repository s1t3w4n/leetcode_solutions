import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * <p>
 * If the tree has more than one mode, return them in any order.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: root = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Solution {

    public int[] findMode(TreeNode root) {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // Find the friend
                TreeNode friend = curr.left;
                while (friend.right != null) {
                    friend = friend.right;
                }

                friend.right = curr;

                // Delete the edge after using it
                TreeNode left = curr.left;
                curr.left = null;
                curr = left;
            } else {
                // Handle the current node
                int num = curr.val;
                if (num == currNum) {
                    currStreak++;
                } else {
                    currStreak = 1;
                    currNum = num;
                }

                if (currStreak > maxStreak) {
                    ans = new ArrayList<>();
                    maxStreak = currStreak;
                }

                if (currStreak == maxStreak) {
                    ans.add(num);
                }

                curr = curr.right;
            }
        }


        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}