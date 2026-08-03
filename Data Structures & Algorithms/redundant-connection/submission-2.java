class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int n) {
        int curr = n;
        while(curr != parent[curr]) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }

        return curr;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) {
            return false;
        }

        if(rank[p2] > rank[p1]) {
            int temp = p2;
            p2 = p1;
            p1 = temp;
        }

        parent[p2] = p1;
        rank[p1] += rank[p2];
        return true;
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int EDGE_COUNT = edges.length;
        int[] result = new int[2];
        UnionFind uf = new UnionFind(EDGE_COUNT+1);

        for(int[] edge : edges) {
            if(!uf.union(edge[0], edge[1])) {
                result = edge;
            }
        }

        return result;
    }
}
