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

    public void findNodesAndPlotAncestors(TreeNode node, TreeNode searchNode, Map<Integer, TreeNode> treeMap, int level) {
        if(node == null) {
            return;
        }

        treeMap.put(level, node);

        if(node.val == searchNode.val) {
            return;
        } else if (node.val < searchNode.val) {
            findNodesAndPlotAncestors(node.right, searchNode, treeMap, level+1);
        } else {
            findNodesAndPlotAncestors(node.left, searchNode, treeMap, level+1);
        }
    }

    public TreeNode findLowestCommonAncestor(TreeMap<Integer, TreeNode> mapP, TreeMap<Integer, TreeNode> mapQ) {
        if(mapP.size() > mapQ.size()) {
            TreeMap<Integer, TreeNode> temp = mapP;
            mapP = mapQ;
            mapQ = temp;
        }

        Integer lowestLevel = mapP.lastKey();

        while(lowestLevel >= 0) {
            if(!mapP.containsKey(lowestLevel) || !(mapQ.get(lowestLevel) == mapP.get(lowestLevel))) {
                lowestLevel--;
                continue;
            } else {
                return mapP.get(lowestLevel);
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeMap<Integer, TreeNode> treeMapP = new TreeMap<Integer, TreeNode>();
        TreeMap<Integer, TreeNode> treeMapQ = new TreeMap<Integer, TreeNode>();

        findNodesAndPlotAncestors(root, p, treeMapP, 0);
        findNodesAndPlotAncestors(root, q, treeMapQ, 0);

        System.out.println("p node val: " + p.val);
        System.out.println("q node val: " + q.val);
        System.out.println("treeMapP: ");
        treeMapP.forEach((k, v) -> System.out.println("  level " + k + " -> node(" + v.val + ")"));
        System.out.println("treeMapQ: ");
        treeMapQ.forEach((k, v) -> System.out.println("  level " + k + " -> node(" + v.val + ")"));

        return findLowestCommonAncestor(treeMapP, treeMapQ);
    }
}
