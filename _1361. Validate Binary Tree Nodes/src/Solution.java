import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 * <p>
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 * <p>
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * n == leftChild.length == rightChild.length
 * 1 <= n <= 10^4
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println(new Solution().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println(new Solution().validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1}));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        seen.add(root);
        stack.push(root);

        while (Boolean.FALSE.equals(stack.isEmpty())) {
            int node = stack.pop();
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }

                    stack.push(child);
                    seen.add(child);
                }
            }
        }
        return seen.size() == n;
    }

    public int findRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }

        for (int node : right) {
            children.add(node);
        }

        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}