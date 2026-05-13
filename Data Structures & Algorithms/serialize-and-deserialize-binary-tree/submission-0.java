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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();

        class Inner {
            String dfs(TreeNode node) {
                if(node == null) {
                    result.add("N");
                    return "";
                }

                result.add(String.valueOf(node.val));
                dfs(node.left);
                dfs(node.right);
                return "";
            }
        }

        new Inner().dfs(root);
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] step = {0};

        class Inner {
            TreeNode dfs() {
                if(values[step[0]].equals("N")) {
                    step[0]++;
                    return null;
                }

                TreeNode node = new TreeNode(Integer.parseInt(values[step[0]]));
                step[0]++;
                node.left = dfs();
                node.right = dfs();
                return node;
            }
        }

        return new Inner().dfs();
    }
}
