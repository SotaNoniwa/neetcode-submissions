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

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey() == true;
    }

    private Pair<Boolean, Integer> dfs(TreeNode root) {
        // Empty tree is considered balanced
        if (root == null) {
            // Pair -> <isBalanced, height>
            Pair<Boolean, Integer> pair = new Pair<>(true, 0);
            return pair;
        }

        Pair<Boolean, Integer> left = dfs(root.left);
        Pair<Boolean, Integer> right = dfs(root.right);

        boolean isBalanced = left.getKey() == true && right.getKey() == true
                && Math.abs(left.getValue() - right.getValue()) <= 1;

        int height = Math.max(left.getValue(), right.getValue()) + 1;

        Pair<Boolean, Integer> pair = new Pair<>(isBalanced, height);
        return pair;
    }
}
