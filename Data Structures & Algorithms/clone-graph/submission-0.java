/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
   private Node dfs(Node node, Map<Node, Node> oldNewMap) {
        if(node == null) {
            return null;
        }

        if(oldNewMap.containsKey(node)) {
            return oldNewMap.get(node);
        }

        Node copy = new Node(node.val);
        oldNewMap.put(node, copy);

        for(Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, oldNewMap));
        }

        return copy;

    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldNewMap = new HashMap<Node, Node>();
        return dfs(node, oldNewMap);
    }
}