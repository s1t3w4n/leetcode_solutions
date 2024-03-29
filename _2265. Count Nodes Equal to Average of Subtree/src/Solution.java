import javafx.util.Pair;

/**
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
 * <p>
 * Note:
 * <p>
 * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 * A subtree of root is a tree consisting of root and all of its descendants.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,8,5,0,1,null,6]
 * Output: 5
 * Explanation:
 * For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 * For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 * For the node with value 0: The average of its subtree is 0 / 1 = 0.
 * For the node with value 1: The average of its subtree is 1 / 1 = 1.
 * For the node with value 6: The average of its subtree is 6 / 1 = 6.
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */
public class Solution {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    Pair<Integer, Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        // First iterate over left and right subtrees.
        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);

        int nodeSum = left.getKey() + right.getKey() + root.val;
        int nodeCount = left.getValue() + right.getValue() + 1;

        // Check if the average of the subtree is equal to the node value.
        if (root.val == nodeSum / (nodeCount)) {
            count++;
        }

        // Return the sum of nodes and the count in the subtree.
        return new Pair(nodeSum, nodeCount);
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