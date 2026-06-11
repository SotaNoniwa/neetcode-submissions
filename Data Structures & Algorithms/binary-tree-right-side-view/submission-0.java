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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideNodes = new ArrayList<>();
        if (root == null) {
            return rightSideNodes; // empty list
        }

        // BFS approach
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Keep track of right most node at the level
            TreeNode rightMostNode = null;

            int numOfNodesAtLevel = queue.size();
            for (int i = 0; i < numOfNodesAtLevel; i++) {
                TreeNode node = queue.poll(); // dequeue node
                rightMostNode = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (rightMostNode != null) {
                rightSideNodes.add(rightMostNode.val);
            }
        }
        return rightSideNodes;
    }
}
