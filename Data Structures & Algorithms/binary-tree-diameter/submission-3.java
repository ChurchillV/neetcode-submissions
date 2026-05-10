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

    public int diameter = 0;

    public int dfs(TreeNode node) {
        if(node == null ) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
}
