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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> nodesPerLevel = new ArrayList<>();
            
            int numOfNodesAtLevel = queue.size();
            for (int i = 0; i < numOfNodesAtLevel; i++) {
                TreeNode node = queue.poll();
                nodesPerLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            nodesList.add(nodesPerLevel);
        }
        return nodesList;
    }
}
