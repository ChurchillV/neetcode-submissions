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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> treeMap = new HashMap<>();
        treeMap.put(null, new int[]{0, 0});

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.peek();

            if(node.left != null && !treeMap.containsKey(node.left)) {
                nodeStack.push(node.left);
            } else if(node.right != null && !treeMap.containsKey(node.right)) {
                nodeStack.push(node.right);
            } else {
                node = nodeStack.pop();

                int[] leftData = treeMap.get(node.left);
                int[] rightData = treeMap.get(node.right);

                int leftHeight = leftData[0];
                int leftDiameter = leftData[1];

                int rightHeight = rightData[0];
                int rightDiameter = rightData[1];
                
                int height = 1 + Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));

                treeMap.put(node, new int[]{ height, diameter });
            }
        }

        return treeMap.get(root)[1];
    }
}
