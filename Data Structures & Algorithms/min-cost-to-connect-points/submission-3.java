class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> edges = new HashMap();
        int SIZE = points.length;

        for(int i = 0; i < SIZE; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            for(int j = i+1; j < SIZE; j++) {
                int xj = points[j][0];
                int yj = points[j][1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                // Add as edges for both points
                edges.computeIfAbsent(j, p -> new ArrayList<int[]>()).add(new int[]{dist, i});
                edges.computeIfAbsent(i, p -> new ArrayList<int[]>()).add(new int[]{dist, j});
            }
        }

        int result = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet();

        while(visited.size() < SIZE) {
            int[] minPoint = minHeap.poll();
            int dist = minPoint[0];
            int point = minPoint[1];
            if(visited.contains(point)) {
                continue;
            }
            visited.add(point);
            result += dist;
            for(int[] edge : edges.getOrDefault(point, Collections.emptyList())) {
                if(!visited.contains(edge[1])) {
                    minHeap.offer(edge);
                }
            }
        }

        return result;
    }
}
