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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left, maxDiameter);
        int right = dfs(node.right, maxDiameter);
        int height = Math.max(left, right) + 1;

        maxDiameter[0] = Math.max(maxDiameter[0], left + right + 2);

        return height;
    }
}
