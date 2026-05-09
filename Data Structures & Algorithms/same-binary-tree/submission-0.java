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

    public void traverse(TreeNode node, List arr) {
        if(node == null) {
            return;
        }

        arr.add(node.val);

        // Check if the node is a leaf node
        if(node.left == null && node.right == null) {
            return;
        }

        if(node.left == null) {
            arr.add(null);
        } else {
            traverse(node.left, arr);
        }


        if(node.right == null) {
            arr.add(null);
        } else {
            traverse(node.right, arr);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> arrP = new ArrayList<>();
        List<Integer> arrQ = new ArrayList<>();

        traverse(p, arrP);
        traverse(q, arrQ);

        return arrP.equals(arrQ);
    }
}
