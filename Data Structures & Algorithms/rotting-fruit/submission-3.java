class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int time = 0;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList(); // x, y, time (0 at the start)

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] == 1) {
                    freshCount++;
                } else if(grid[row][col] == 2) {
                    queue.offer(new int[]{row, col, 0});
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()) {
            int[] details = queue.poll();
            int r = details[0];
            int c = details[1];
            int timestamp = details[2];

            for(int[] dir : dirs) {
                int row = r + dir[0];
                int col = c + dir[1];
                time = Math.max(time, timestamp);

                if(
                    (row < 0 || row >= ROWS) || 
                    (col < 0 || col >= COLS) ||
                    (grid[row][col] != 1)
                ) {
                    continue;
                }

                grid[row][col] = 2;
                freshCount--;
                queue.offer(new int[]{row, col, timestamp+1});
            }
        }

        return freshCount == 0 ? time : -1;
    }
}
