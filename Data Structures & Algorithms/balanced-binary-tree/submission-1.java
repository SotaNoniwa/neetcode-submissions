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
    int ERROR = Integer.MIN_VALUE;

    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != ERROR;
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = calculateHeight(root.left);
        if (leftHeight == ERROR) {
            return ERROR; // Pass error up
        }

        int rightHeight = calculateHeight(root.right);
        if (rightHeight == ERROR) {
            return ERROR; // Pass error up
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return ERROR; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
