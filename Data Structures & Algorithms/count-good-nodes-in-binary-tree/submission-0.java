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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }

        int numOfNodes = 0;
        if (maxValue <= root.val) {
            numOfNodes++;
        }

        maxValue = Math.max(maxValue, root.val);

        int leftSubTree = dfs(root.left, maxValue);
        int rightSubTree = dfs(root.right, maxValue);
        return leftSubTree + rightSubTree + numOfNodes;
    }
}
