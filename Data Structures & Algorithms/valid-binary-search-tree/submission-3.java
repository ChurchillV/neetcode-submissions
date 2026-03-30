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
    public boolean isValidBST(TreeNode root) {
        int leftLimit = Integer.MIN_VALUE;
        int rightLimit = Integer.MAX_VALUE;

        return validate(root, leftLimit, rightLimit);
    }

    public boolean validate(TreeNode node, int leftLimit, int rightLimit) {
        if(node == null) {
            return true;
        }

        if(!(leftLimit < node.val && node.val < rightLimit)) {
            return false;
        }

        return validate(node.left, leftLimit, node.val) && validate(node.right, node.val, rightLimit);

    }
}
