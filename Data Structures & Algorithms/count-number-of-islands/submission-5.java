class Solution {
    private boolean isValidLand(char[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length)    && 
               (col >= 0 && col < grid[0].length) &&
               (!visited[row][col])               &&
               (grid[row][col] == '1');
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] direction : directions) {
            int x = direction[0] + row;
            int y = direction[1] + col;

            if(isValidLand(grid, visited, x, y)) {
                dfs(grid, visited, x, y);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(!visited[row][col] && grid[row][col] == '1') {
                    dfs(grid, visited, row, col);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}
