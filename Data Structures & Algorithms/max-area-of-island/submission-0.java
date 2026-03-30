class Solution {
    public boolean isValidLand(int[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length)
                && !visited[row][col] && grid[row][col] == 1;
    }

    public int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int area = 1;

        visited[row][col] = true;

        int[][] directions = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};

        for(int[] direction : directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;

            if(isValidLand(grid, visited, newRow, newCol)) {
                area += dfs(grid, visited, newRow, newCol);
            }
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(grid[row][col] == 1 && !visited[row][col]) {
                    int newArea = dfs(grid, visited, row, col);
                    maxArea = Math.max(newArea, maxArea);
                }
            }
        }

        return maxArea;
    }
}
