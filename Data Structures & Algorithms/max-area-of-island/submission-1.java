class Solution {    
    private boolean isValidLand(int[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length)    &&
               (col >= 0 && col < grid[0].length) &&
               !visited[row][col]                &&
               grid[row][col] == 1;
    }

    private int findIslandArea(
        int[][] grid, 
        boolean[][] visited, 
        int row, 
        int col
    ) {
        int area = 1;
        int[][] directions = { {0,1}, {0,-1}, {1,0}, {-1,0} };
        visited[row][col] = true;
        
        for(int[] direction : directions) {
            int dy = col + direction[1];
            int dx = row + direction[0];

            if(isValidLand(grid, visited, dx, dy)) {
                area += findIslandArea(grid, visited, dx, dy);
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;  
        boolean[][] visited = new boolean[ROWS][COLS];
        int maxArea = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(isValidLand(grid, visited, r, c)) {
                    int area = findIslandArea(grid, visited, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }  

        return maxArea;
    }
}
