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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // First node in preorder is root
        TreeNode root = new TreeNode(preorder[0]);

        int mid = -1;
        // Searching for index of root node in inorder.
        // mid, location of root in inorder array, is used to identify how many nodes
        // are in left subtree and right subtree.
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i; // found the index
                break;
            }
        }

        // Slice preorder array, leftPreoder array only contains nodes which are in left
        // subtree
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        // Slice inorder array, leftInorder array only contains nodes which are in left
        // subtree
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        // Build left subtree recursively
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
