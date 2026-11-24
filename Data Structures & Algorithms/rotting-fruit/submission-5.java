class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] coords = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int freshCount = 0;
        int time = 0;
        Queue<int[]> rotten = new LinkedList(); // [row, col, timestamp]

        // Counting and taking rotten fruit
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] == 1) {
                    freshCount++;
                } else if(grid[row][col] == 2) {
                    rotten.offer(new int[]{ row, col, time });
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        // BFS
        while(!rotten.isEmpty()) {
            int[] fruitDetails = rotten.poll();
            int r = fruitDetails[0];
            int c = fruitDetails[1];
            int timestamp = fruitDetails[2];
            time = Math.max(timestamp, time);

            for(int[] coord : coords) {
                int x = r + coord[0];
                int y = c + coord[1];

                if(
                    (x < 0 || y < 0)          ||
                    (x >= ROWS || y >= COLS)  ||
                    grid[x][y] != 1
                ) {
                    continue;
                }

                grid[x][y] = 2;
                freshCount--;
                rotten.offer(new int[]{ x, y, timestamp+1 });
            }
        }

        return freshCount == 0 ? time : -1;
    }
}
