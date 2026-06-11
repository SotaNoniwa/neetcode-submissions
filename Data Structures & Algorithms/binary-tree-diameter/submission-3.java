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
        calculateDiameter(root, maxDiameter);
        return maxDiameter[0];
    }

    private int calculateDiameter(TreeNode root, int[] maxDiameter) {
        if (root == null) {
            return -1;
        }

        int left = calculateDiameter(root.left, maxDiameter);
        int right = calculateDiameter(root.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], left + right + 2);

        return Math.max(left, right) + 1;
    }
}
