class Solution {
    private Map<Integer, ArrayList<Integer>> edgeMap = new HashMap();
    private Set<Integer> visited = new HashSet();
    private Set<Integer> visitedEdges = new HashSet();

    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList());
        }            

        for(int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && visited.size() == n;
    }

    private boolean dfs(int node, int prev) {
        if(visited.contains(node)) {
            return false;
        }

        visited.add(node);

        if(edgeMap.get(node).isEmpty()) {
            return true;
        }


        for(int edge : edgeMap.get(node)) {
            if(edge != prev && !dfs(edge, node)) {
                return false;
            }
        }

        return true;
    }
}
