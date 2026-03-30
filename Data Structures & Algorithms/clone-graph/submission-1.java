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

        // Keep a reference of the start node
        Node startNode = node;

        // Have a hashmap to track nodes and their references
        Map<Node, Node> nodes = new HashMap<>();

        // Keep track of the nodes to be visited
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(startNode);

        // Set to track visited nodes
        Set<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(startNode);

        while (!nodeStack.empty()) {
            Node currentNode = nodeStack.pop();
            nodes.put(currentNode, new Node(currentNode.val));

            for(Node neighbour : currentNode.neighbors) {
                if(!visitedNodes.contains(neighbour)) {
                    visitedNodes.add(neighbour);
                    nodeStack.add(neighbour);
                }
            }
        }

        for(Map.Entry<Node,Node> nodeEntry: nodes.entrySet()) {
            for(Node neighbour : nodeEntry.getKey().neighbors) {
                Node newNeighbour = nodes.get(neighbour);
                nodeEntry.getValue().neighbors.add(newNeighbour);
            }
        }

        return nodes.get(startNode);
    }
}