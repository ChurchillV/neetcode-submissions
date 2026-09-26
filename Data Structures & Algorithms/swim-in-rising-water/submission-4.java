class Solution {
    PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
    Set<Integer> visited = new HashSet();
    int[][] directions = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int MAX = grid.length-1;
        minHeap.offer(new int[]{ grid[0][0], 0 ,0});
        visited.add(grid[0][0]);

        while(!minHeap.isEmpty()) {
            int[] path = minHeap.poll();
            int max = path[0];
            int row = path[1];
            int col = path[2];

            if(row == MAX && col == MAX) {
                return max;
            }

            for(int[] direction : directions) {
                int dx = row + direction[0];
                int dy = col + direction[1];

                if(
                    (dx >= 0 && dx <= MAX) &&
                    (dy >= 0 && dy <= MAX) &&
                    !visited.contains(grid[dx][dy]) 
                ) {
                    minHeap.offer(new int[] { Math.max(max, grid[dx][dy]), dx, dy});
                    visited.add(grid[dx][dy]);
                }
            }
        }

        return -1;
    }
}
