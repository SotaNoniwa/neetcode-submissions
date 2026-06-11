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

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int goodNode;
        if (node.val >= maxVal) {
            maxVal = node.val;
            goodNode = 1;
        } else {
            goodNode = 0;
        }

        int leftSubTree = dfs(node.left, maxVal);
        int rightSubTree = dfs(node.right, maxVal);
        return leftSubTree + rightSubTree + goodNode;
    }
}
