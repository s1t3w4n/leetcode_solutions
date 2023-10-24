import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * Example 1:
 * <p>
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 * <p>
 * Input: root = [1,2,3]
 * Output: [1,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree will be in the range [0, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Solution {
    List<Integer> ans;

    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
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