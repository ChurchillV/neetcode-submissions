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
    public Node cloneGraph(Node node) {
       if(node == null) { return null; }

        Node startNode = node;
        Set<Node> visitedNodes = new HashSet<>();
        Map<Node, Node> nodes = new HashMap<>();
        Stack<Node> nodeStack = new Stack<>();

        nodeStack.add(startNode);
        visitedNodes.add(startNode);
        
        while(!nodeStack.empty()) {
            Node currentNode = nodeStack.pop();
            nodes.put(currentNode, new Node(currentNode.val));

            for(Node neighbor : currentNode.neighbors) {
                if(!visitedNodes.contains(neighbor)) {
                    nodeStack.add(neighbor);
                    visitedNodes.add(neighbor);
                }
            }
        }

        for(Map.Entry<Node,Node> nodeEntry : nodes.entrySet()) {
            for(Node neighbor : nodeEntry.getKey().neighbors) {
                Node newNeighbor = nodes.get(neighbor);
                nodeEntry.getValue().neighbors.add(newNeighbor);
            }
        }

        return nodes.get(startNode);
    }
}