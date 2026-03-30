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
    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
        stack.push(root);
        nodeDepthMap.put(root, 1);
        int result = 0;

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            int depth = nodeDepthMap.get(currentNode);

            if(currentNode != null) {
                result = Math.max(result, depth);
                stack.push(currentNode.left);
                stack.push(currentNode.right);
                nodeDepthMap.put(currentNode.left, depth+1);
                nodeDepthMap.put(currentNode.right, depth+1);
            }
        }

        return result;
    }
}
