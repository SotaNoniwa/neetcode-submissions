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
        // dfs returns height of node, we can't directly return maxDiameter. Thus we use array to keep track maxDiameter
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        // height of NIL node is 0
        if (root == null) {
            return 0;
        }

        // Calculate left and right subtree's heights
        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);

        // Update max diameter
        diameter[0] = Math.max(diameter[0], left + right);

        int height = 1 + Math.max(left, right);
        return height;
    }
}
