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

    public List<Integer> arr = new ArrayList<Integer>();

    public void traverse(TreeNode root) {
        if(root == null) { 
            return;
        }


        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return arr.get(k-1);
    }
}
