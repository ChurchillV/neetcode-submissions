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
    int goodNodeCount = 0;

    public void countGoodNodes(TreeNode root, int highestValue) {
        if(root == null) {
            return;
        }

        if(root.val >= highestValue) {
            goodNodeCount++;
            highestValue = root.val;
        }

        countGoodNodes(root.left, highestValue);
        countGoodNodes(root.right, highestValue);
    } 

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);

        return goodNodeCount;
    }
}
