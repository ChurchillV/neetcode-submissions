class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int INF = Integer.MAX_VALUE;
        Queue<int[]> gridQueue = new LinkedList<>();

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] == 0) {
                    gridQueue.offer(new int[]{row, col});
                }
            }
        }

        // bfs
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!gridQueue.isEmpty()) {
            int[] currentPoint = gridQueue.poll();
            int row = currentPoint[0];
            int col = currentPoint[1];

            for(int[] direction : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != INF) {
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                gridQueue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
