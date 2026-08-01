class Solution {
    private Map<Integer, ArrayList<Integer>> edgeMap = new HashMap();
    private Set<Integer> visited = new HashSet();
    int count = 0;

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList());
        }

        for(int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node) {
        visited.add(node);

        for(int neighbor : edgeMap.get(node)) {
            if(!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}
