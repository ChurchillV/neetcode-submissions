class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int time = 0;
        int freshCount = 0;
        int[][] dirs = new int[][]{ {0,1}, {0,-1}, {1,0}, {-1,0} };
        Queue<int[]> rotten = new LinkedList(); // x, y, time

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    freshCount++;
                } else if(grid[r][c] == 2) {
                    rotten.offer(new int[]{r, c, 0});
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        while(!rotten.isEmpty()) {
            int[] details = rotten.poll();
            int row = details[0];
            int col = details[1];
            int timestamp = details[2];
            time = Math.max(time, timestamp);


            for(int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(
                    (r < 0 || r >= ROWS) || 
                    (c < 0 || c >= COLS) || 
                    grid[r][c] != 1
                ) {
                    continue;
                }

                grid[r][c] = 2;
                freshCount--;
                rotten.offer(new int[]{ r, c, timestamp+1});
            }
        }

        return freshCount == 0 ? time : -1;
    }
}