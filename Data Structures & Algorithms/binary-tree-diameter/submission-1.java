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
        int[] maxLen = new int[1];
        maxDepth(root, maxLen);
        return maxLen[0];
    }

    private int maxDepth(TreeNode node, int[] maxLen) {
        if (node == null) {
            return -1;
        }

        int left = maxDepth(node.left, maxLen);
        int right = maxDepth(node.right, maxLen);

        maxLen[0] = Math.max(maxLen[0], left + right + 2);

        return Math.max(left, right) + 1;
    }
}
