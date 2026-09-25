class Solution {
    private Set<Integer> visited = new HashSet();
    private PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0])); // [value, row, col]
    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        visited.add(grid[0][0]);
        int MAX = grid.length-1;

        while(!minHeap.isEmpty()) {
            int[] path = minHeap.poll();
            int pathMax = path[0];
            int row = path[1];
            int col = path[2];

            if(row == MAX && col == MAX) {
                return pathMax;
            }

            for(int[] direction : directions) {
            int dx = direction[0] + row;
            int dy = direction[1] + col;

                if(
                    (dx >= 0 && dx <= MAX) &&
                    (dy >= 0 && dy <= MAX) &&
                    !visited.contains(grid[dx][dy])
                ) {
                    minHeap.offer(new int[]{ Math.max(pathMax, grid[dx][dy]), dx, dy});
                    visited.add(grid[dx][dy]);
                }
            }
        }

        return 0;
    }
}
