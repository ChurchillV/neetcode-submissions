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
    int preIdx = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int l, int r) {
        if(l > r) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int mid = indices.get(rootVal);
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);

        return root;
    }
}
