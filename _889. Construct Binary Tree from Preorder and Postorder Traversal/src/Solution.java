import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void main(String[] args) {
        // 1,2,3,4,5,6,7
        System.out.println(new Solution().constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
        // 1
        System.out.println(new Solution().constructFromPrePost(new int[]{1}, new int[]{1}));
        // 2,1
        System.out.println(new Solution().constructFromPrePost(new int[]{2,1}, new int[]{1,2}));
    }

    private final HashSet<Integer> used = new HashSet<>();
    private final Map<Integer, Integer> preorderMap = new HashMap<>();
    private final Map<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < preorder.length; i++) {
            this.preorderMap.put(preorder[i], i);
        }
        for (int i = 0; i < postorder.length; i++) {
            this.postorderMap.put(postorder[i], i);
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        used.add(preorder[0]);
        constructFromPrePost(treeNode, preorder, postorder);
        return treeNode;
    }

    private void constructFromPrePost(TreeNode currNode, int[] preorder, int[] postorder) {
        int leftIndex = preorderMap.get(currNode.val) + 1;
        int rightIndex = postorderMap.get(currNode.val) - 1;
        if (leftIndex < preorder.length) {
            int leftValue = preorder[leftIndex];
            if (!used.contains(leftValue)) {
                currNode.left = new TreeNode(leftValue);
                used.add(leftValue);
            }
        }
        if (rightIndex > 0) {
            int rightValue = postorder[rightIndex];
            if (!used.contains(rightValue)){
                currNode.right = new TreeNode(rightValue);
                used.add(rightValue);
            }
        }
        if (currNode.left != null) {
            constructFromPrePost(currNode.left, preorder, postorder);
        }
        if (currNode.right != null) {
            constructFromPrePost(currNode.right, preorder, postorder);
        }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left + "\n" +
                    ", right=" + right + "\n" +
                    '}';
        }
    }
}